package br.com.dh.spring03.service;

import br.com.dh.spring03.dto.VehicleDTO;
import br.com.dh.spring03.exception.NotFoundException;
import br.com.dh.spring03.model.Vehicle;
import java.util.List;

public interface IVehicle {
    List<VehicleDTO> getAllVehicles();

    Vehicle getVehicle(String plate) throws NotFoundException;

    List<Vehicle> getAllOrderedByValue();

    void saveVehicle(Vehicle vehicle);

    List<Vehicle> getByModel(String model);
}
