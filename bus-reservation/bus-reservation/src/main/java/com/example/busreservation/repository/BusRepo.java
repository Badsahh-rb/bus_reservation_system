package com.example.busreservation.repository;

import com.example.busreservation.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepo extends JpaRepository<Bus,Long> {
}
