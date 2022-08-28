package com.example.busreservation.controller;

import com.example.busreservation.model.Bus;
import com.example.busreservation.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "", allowedHeaders = "")
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping(value = "/dummy/savebus")
    public void saveBus(@RequestBody Bus bus){
        busService.addBus(bus);
    }

    @GetMapping(value = "/getBuses")
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }
    @GetMapping(value="/getBuses/{id}")
    public Optional<Bus> getBusById(@PathVariable("id") Long bus_id){
        return busService.getBusbyId(bus_id);
    }
}
