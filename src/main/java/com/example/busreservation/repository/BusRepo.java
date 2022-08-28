package com.example.busreservation.repository;

import com.example.busreservation.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BusRepo extends JpaRepository<Bus,Long> {
}
