package com.example.busreservation.repository;

import com.example.busreservation.model.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepo extends JpaRepository<Tickets,Long> {
}
