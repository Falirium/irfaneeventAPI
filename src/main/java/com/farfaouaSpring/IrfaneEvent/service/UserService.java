package com.farfaouaSpring.IrfaneEvent.service;

import java.util.Optional;

import com.farfaouaSpring.IrfaneEvent.modal.Event;
import com.farfaouaSpring.IrfaneEvent.modal.User;

public interface UserService {

    User getUserByID(long id);
    User addUser(User newUser);
    String authenticate(String username, String password);
    Event participate(Event event, User user);
    String desister(Event event, User user);
    Event addEvent(Event newEvent);
    
    

    
    
}
