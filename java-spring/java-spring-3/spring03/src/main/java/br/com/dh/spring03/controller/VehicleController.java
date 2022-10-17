package br.com.dh.spring03.controller;

import br.com.dh.spring03.model.Vehicle;
import br.com.dh.spring03.service.IVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired // Dependency Injection
    private IVehicle service;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return new ResponseEntity<>(service.getAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/{plate}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable String plate) {
        Vehicle vehicle = service.getVehicle(plate);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @GetMapping("/by-value")
    public ResponseEntity<List<Vehicle>> getAllOrderedByValue() {
        return new ResponseEntity<>(service.getAllOrderedByValue(), HttpStatus.OK);
    }

}
