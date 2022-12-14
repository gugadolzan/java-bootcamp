package br.com.dh.spring03.service;

import br.com.dh.spring03.dto.VehicleDTO;
import br.com.dh.spring03.exception.NotFoundException;
import br.com.dh.spring03.model.Vehicle;
import br.com.dh.spring03.repository.VehicleRepo;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService implements IVehicle {

    @Autowired
    private VehicleRepo repo;

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return repo
            .getAll()
            .stream()
            .map(VehicleDTO::new)
            .collect(Collectors.toList());
    }

    @Override
    public Vehicle getVehicle(String plate) throws NotFoundException {
        Optional<Vehicle> vehicle = repo.getVehicle(plate);

        if (vehicle.isEmpty()) {
            throw new NotFoundException("Vehicle not found");
        }

        return vehicle.get();
    }

    @Override
    public List<Vehicle> getAllOrderedByValue() {
        List<Vehicle> vehicles = repo.getAll();

        return vehicles.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        repo.saveVehicle(vehicle);
    }

    @Override
    public List<Vehicle> getByModel(String model) {
        return getAllOrderedByValue()
            .stream()
            .filter(v -> v.getModel().equalsIgnoreCase(model))
            .collect(Collectors.toList());
    }
}
