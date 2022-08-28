package com.example.busreservation.services;

import com.example.busreservation.model.Bus;
import com.example.busreservation.model.Tickets;
import com.example.busreservation.model.User;
import com.example.busreservation.repository.BusRepo;
import com.example.busreservation.repository.TicketsRepo;
import com.example.busreservation.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService{
    @Autowired
    private BusRepo busRepo;

    @Autowired
    private TicketsRepo ticketsRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Tickets bookTicket(Long busId, String email,int numberOfSeats) {
        Optional<Bus> bus= busRepo.findById(busId);
        if(bus.isEmpty()){
            throw new RuntimeException("Bus does not exist");
        }
        User user=userRepo.findOneByEmail(email);
        if (user == null) {
            throw new RuntimeException("User does not exist!");
        }
        int ticketCount =bus.get().getTickets() != null? bus.get().getTickets().size():0;
        if(ticketCount+1 > bus.get().getSeats()){
            throw new RuntimeException("No Seats");
        }
        Tickets tickets=new Tickets();
        tickets.setTicketNumber(UUID.randomUUID().toString());
        tickets.setBus(bus.get());
        tickets.setTicketPrice(bus.get().getPrice().multiply(BigDecimal.valueOf(numberOfSeats)));
        tickets.setNumberOfSeats(numberOfSeats);
        tickets.setReservationDate(new Date());
        tickets.setUser(user);
        tickets.setPaymentStatus(false);
        return ticketsRepo.save(tickets);
    }

    @Override
    public List<Tickets> getAllTickets() {
        return ticketsRepo.findAll();

    }

    @Override
    public List<Tickets> getAllTicketsOfUser(String email) {
        User user = userRepo.findOneByEmail(email);
        if (user == null) {
            throw new RuntimeException("User does not exist!");
        }
        log.info("User {}",user.getId());
        return ticketsRepo.findByUserId(user.getId());
    }

    @Override
    public Optional<Tickets> getTicketById(Long id) {
        return ticketsRepo.findById(id);
    }

}
