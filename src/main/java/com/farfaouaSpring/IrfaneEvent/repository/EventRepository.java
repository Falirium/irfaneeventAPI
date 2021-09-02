package com.farfaouaSpring.IrfaneEvent.repository;

import com.farfaouaSpring.IrfaneEvent.modal.Event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    
}
