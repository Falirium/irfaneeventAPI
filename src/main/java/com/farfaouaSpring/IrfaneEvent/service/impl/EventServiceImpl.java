package com.farfaouaSpring.IrfaneEvent.service.impl;

import java.util.List;

import com.farfaouaSpring.IrfaneEvent.exception.ResourceNotFoundException;
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
        return eventRepository.findById(id_event).orElseThrow(() -> new ResourceNotFoundException("event not found", "events", eventRepository));
    }

    @Override
    public Event addEvent(Event newEvent) {
        // TODO Auto-generated method stub
        return eventRepository.save(newEvent);
    }

	@Override
	public Event save(Event event) {
		// TODO Auto-generated method stub
		return eventRepository.saveAndFlush(event);
	}

    @Override
    public Event update(Event updatedEvent) {
        // TODO Auto-generated method stub
        
        return eventRepository.save(updatedEvent);
    }
    
}
