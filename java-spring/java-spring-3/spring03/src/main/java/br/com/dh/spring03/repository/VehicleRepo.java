package br.com.dh.spring03.repository;

import br.com.dh.spring03.model.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepo {

    private final String fileLink = "src/main/resources/vehicles.json";
    ObjectMapper mapper = new ObjectMapper();

    public List<Vehicle> getAll() {
        List<Vehicle> vehicles = null;

        try {
            vehicles = Arrays.asList(mapper.readValue(new File(fileLink), Vehicle[].class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public Optional<Vehicle> getVehicle(String plate) {
        List<Vehicle> vehicles = getAll();

        for (Vehicle v : vehicles) {
            if (v.getPlate().equals(plate)) {
                return Optional.of(v);
            }
        }

        return Optional.empty();
    }

}