package com.farfaouaSpring.IrfaneEvent.service.impl;

import java.util.List;

import com.farfaouaSpring.IrfaneEvent.modal.Event;
import com.farfaouaSpring.IrfaneEvent.repository.EventRepository;
import com.farfaouaSpring.IrfaneEvent.service.EventService;

import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    public EventServiceImpl (EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        // TODO Auto-generated method stub
        return eventRepository.findAll();
    }

    @Override
    public Event getEventByID(long id_event) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Event addEvent(Event newEvent) {
        // TODO Auto-generated method stub
        return eventRepository.save(newEvent);
    }
    
}
