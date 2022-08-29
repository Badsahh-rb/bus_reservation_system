package com.example.busreservation.controller;

import com.example.busreservation.model.Bus;
import com.example.busreservation.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping(value = "/admin/dummy/addbus")
    public String saveBus(@RequestBody Bus bus){
        return busService.addBus(bus);
    }
    @PostMapping(value = "/admin/updateBus")
    public void updateBus(@RequestBody Bus bus){
        busService.updateBus(bus);
    }

    @GetMapping(value = "/admin/getBuses")
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }
    @GetMapping(value="/getBuses/{id}")
    public Optional<Bus> getBusById(@PathVariable("id") Long bus_id){
        return busService.getBusbyId(bus_id);
    }
}
