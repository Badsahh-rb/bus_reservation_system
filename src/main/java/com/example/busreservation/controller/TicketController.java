package com.example.busreservation.controller;

import com.example.busreservation.model.Tickets;
import com.example.busreservation.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping(value = "/tickets/book/{bus_id}/{numberOfSeats}")
    public Tickets bookTicket(@PathVariable Long bus_id,@PathVariable int numberOfSeats){
        return ticketService.bookTicket(bus_id,"nirajmuttur@gmail.com",numberOfSeats);
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public List<Tickets> getAllCurrentUserTickets() {
        return ticketService.getAllTicketsOfUser("nirajmuttur@gmail.com");
    }
    @RequestMapping(value = "/admin/tickets", method = RequestMethod.GET)
    public List<Tickets> getAllTickets() {
        return ticketService.getAllTickets();
    }
}
