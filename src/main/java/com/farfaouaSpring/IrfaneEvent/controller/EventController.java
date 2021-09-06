package com.farfaouaSpring.IrfaneEvent.controller;

import java.util.List;

import com.farfaouaSpring.IrfaneEvent.modal.Event;
import com.farfaouaSpring.IrfaneEvent.modal.User;
import com.farfaouaSpring.IrfaneEvent.service.EventService;
import com.farfaouaSpring.IrfaneEvent.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private EventService eventService;
    private UserService userService;

    public EventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    // GET all events
    // "/api/events"
    @GetMapping()
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
    
    // POST an event
    // "/api/events"
    @PostMapping()
    public ResponseEntity<Event> addEvent(@RequestBody Event newEvent) {
        return new ResponseEntity<Event>(eventService.addEvent(newEvent), HttpStatus.CREATED) ;
    }
    
    
    // Get participants to an event
    // /api/{id_event}/participants
    @GetMapping("/{id_event}/participants")
    public ResponseEntity<List<User>> getParticipants(@PathVariable long id_event) {
    	
    	// Get the event from the request
    	Event selectedEvent = eventService.getEventByID(id_event);
    	return new ResponseEntity<List<User>>(selectedEvent.getParticipants(), HttpStatus.ACCEPTED);
 
    
    }

    // Modify an event
    // /api/events/{id_user}/modify
    @PutMapping("/{id_user}/modify")
    public ResponseEntity<Event> modifyEvent(@PathVariable long id_user, @RequestBody Event event) {

        // Get the event and the user
        User user = userService.getUserByID(id_user);

        // Check if the user is the owner

        if (user.getId_user() == event.getCreatedBy().getId_user()) {
            return new ResponseEntity<Event>(eventService.update(event), HttpStatus.CREATED) ;


        } else {

            return null;

        }




    }
}
