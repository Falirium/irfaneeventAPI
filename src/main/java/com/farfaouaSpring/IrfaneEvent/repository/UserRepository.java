package com.farfaouaSpring.IrfaneEvent.repository;

import com.farfaouaSpring.IrfaneEvent.modal.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
