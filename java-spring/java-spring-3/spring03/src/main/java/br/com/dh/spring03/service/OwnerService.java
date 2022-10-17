package br.com.dh.spring03.service;

import br.com.dh.spring03.model.Owner;
import br.com.dh.spring03.model.Vehicle;
import br.com.dh.spring03.repository.OwnerRepo;
import br.com.dh.spring03.repository.VehicleRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService implements IOwner {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private OwnerRepo ownerRepo;

    @Override
    public List<Owner> getAll() {
        List<Vehicle> vehicles = new ArrayList<>(vehicleRepo.getAll());
        List<Owner> owners = new ArrayList<>(ownerRepo.getAll());

        owners.forEach(owner -> {
            for (int i = 0; i < vehicles.size(); i++) {
                if (vehicles.get(i).getOwner_id() == owner.getId()) {
                    owner.addVehicle(vehicles.remove(i));
                    i--;
                }
            }
        });

        return owners;
    }
}
