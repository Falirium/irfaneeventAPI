package com.farfaouaSpring.IrfaneEvent.service;

import java.util.List;
import java.util.Optional;

import com.farfaouaSpring.IrfaneEvent.modal.Event;
import com.farfaouaSpring.IrfaneEvent.modal.User;

public interface UserService {

    User getUserByID(long id);
    User addUser(User newUser);
    User save(User user);
    List<User> getUsers();
    String authenticate(String username, String password);
    Event participate(Event event, User user);
    Event desister(Event event, User user);
    Event addEvent(Event newEvent);
    
    

    
    
}
