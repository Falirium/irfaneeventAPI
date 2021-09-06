package com.farfaouaSpring.IrfaneEvent.controller;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.farfaouaSpring.IrfaneEvent.exception.ResourceNotFoundException;
import com.farfaouaSpring.IrfaneEvent.modal.Event;
import com.farfaouaSpring.IrfaneEvent.modal.User;
import com.farfaouaSpring.IrfaneEvent.service.EventService;
import com.farfaouaSpring.IrfaneEvent.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private UserService userService;
    private EventService eventService;

    public UserController(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }
    
    @GetMapping("/{name}")
    public String getUser(@PathVariable String name) {
        return "Welcome " + name;
    }

    // Get all users
    // /api/users
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.CREATED); 
    }


    // Create an event
    // /api/users/{id_user}/create
    
    @PostMapping("/{id_user}/create") 
    public ResponseEntity<Event> createEvent(@RequestBody Event newEvent, @PathVariable long id_user) {
        User adminUser = userService.getUserByID(id_user);

        
        newEvent.setCreatedBy(adminUser);
        
        adminUser.getParticipatedEvents().add(newEvent);
        
        //Event event = eventService.save(newEvent);
        
        //event.setParticipants(new ArrayList<User>(Arrays.asList(adminUser)));
        
        

        //System.out.println(newEvent.toString());
        //Make this user a participants
        //userService.participate(newEvent, adminUser);
        
        return new ResponseEntity<Event>(userService.addEvent(newEvent), HttpStatus.CREATED);
    }


    //  Add new user
    // /api/users
    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User newUser) {
        return new ResponseEntity<User>(userService.addUser(newUser), HttpStatus.CREATED);
    }


    // Participate to an event
    // /api/users/{id_user}/{id_event}/participate
    @PostMapping("/{id_user}/{id_event}/participate")
    public ResponseEntity<Event> participate(@PathVariable long id_user, @PathVariable long id_event) {
        
        // Get User and Event from the request
        User selectedUser = userService.getUserByID(id_user);
        Event selectedEvent = eventService.getEventByID(id_event);


        return new ResponseEntity<Event>(userService.participate(selectedEvent, selectedUser), HttpStatus.ACCEPTED);
    }


    // Desister from an event
    // /api/users/{id_user}/{id_event}/withdraw
    @PostMapping("/{id_user}/{id_event}/withdraw")
    public ResponseEntity<Event> withdraw(@PathVariable long id_user, @PathVariable long id_event) {
        
        // Get User and Event from the request
        User selectedUser = userService.getUserByID(id_user);
        Event selectedEvent = eventService.getEventByID(id_event);

        return new ResponseEntity<Event>(userService.desister(selectedEvent, selectedUser), HttpStatus.ACCEPTED);
    }
}
