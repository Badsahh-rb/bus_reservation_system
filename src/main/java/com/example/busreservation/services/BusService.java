package com.example.busreservation.services;

import com.example.busreservation.model.Bus;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface BusService {
    String addBus(Bus bus);
    Optional<Bus> getBusbyId(Long bus_id);
    List<Bus> getAllBuses();
    void saveBus(Bus bus);
    void updateBus(Bus bus);
    void deleteBusbyId(Long bus_id);
}
