package com.example.busreservation.repository;

import com.example.busreservation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findOneByEmail(String email);
    User findOneByActivationHash(String activationHash);
}
