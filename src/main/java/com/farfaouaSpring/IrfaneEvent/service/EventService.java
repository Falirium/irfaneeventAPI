package com.farfaouaSpring.IrfaneEvent.service;

import java.util.List;

import com.farfaouaSpring.IrfaneEvent.modal.Event;

public interface EventService {
    
    List<Event> getAllEvents();
    Event getEventByID(long id_event);
    Event addEvent(Event newEvent);
    Event save(Event event);
    Event update(Event updatedEvent);
    String delete(Event deletedEvent);
    
    
}
