package br.com.dh.spring03.service;

import br.com.dh.spring03.exception.NotFoundException;
import br.com.dh.spring03.model.Vehicle;
import br.com.dh.spring03.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicle {

    @Autowired
    private VehicleRepo repo;

    @Override
    public List<Vehicle> getAllVehicles() {
        return repo.getAll();
    }

    @Override
    public Vehicle getVehicle(String plate) throws NotFoundException {
        Optional<Vehicle> vehicle = repo.getVehicle(plate);

        if (vehicle.isEmpty()) {
            throw new NotFoundException("Vehicle not found");
        }

        return vehicle.get();
    }

}
