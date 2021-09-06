package com.farfaouaSpring.IrfaneEvent.service;

import java.util.List;
import java.util.Optional;

import com.farfaouaSpring.IrfaneEvent.modal.Event;
import com.farfaouaSpring.IrfaneEvent.modal.User;

public interface UserService {

    User getUserByID(long id);
    User addUser(User newUser);
    List<User> getUsers();
    String authenticate(String username, String password);
    User participate(Event event, User user);
    String desister(Event event, User user);
    Event addEvent(Event newEvent);
    
    

    
    
}
