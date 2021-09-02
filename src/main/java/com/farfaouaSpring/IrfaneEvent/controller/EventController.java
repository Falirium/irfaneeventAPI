package com.farfaouaSpring.IrfaneEvent.controller;

import java.util.List;

import com.farfaouaSpring.IrfaneEvent.modal.Event;
import com.farfaouaSpring.IrfaneEvent.service.EventService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
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
}
