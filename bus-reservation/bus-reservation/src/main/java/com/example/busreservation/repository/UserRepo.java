package com.example.busreservation.repository;

import com.example.busreservation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
