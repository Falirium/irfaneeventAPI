package com.farfaouaSpring.IrfaneEvent.service.impl;

import java.util.List;
import java.util.Optional;

import com.farfaouaSpring.IrfaneEvent.exception.ResourceNotFoundException;
import com.farfaouaSpring.IrfaneEvent.modal.Event;
import com.farfaouaSpring.IrfaneEvent.modal.User;
import com.farfaouaSpring.IrfaneEvent.repository.EventRepository;
import com.farfaouaSpring.IrfaneEvent.repository.UserRepository;
import com.farfaouaSpring.IrfaneEvent.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private EventRepository eventRepository;

    public UserServiceImpl(UserRepository userRepository, EventRepository eventRepository){
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public User getUserByID(long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user id not found", "users", id));
    }

    @Override
    public String authenticate(String username, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Event participate(Event event, User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String desister(Event event, User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User addUser(User newUser) {
        // TODO Auto-generated method stub
        return userRepository.save(newUser);
    }

    @Override
    public Event addEvent(Event newEvent) {
        // TODO Auto-generated method stub
        return eventRepository.save(newEvent);
    }

    @Override
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }
    
}
