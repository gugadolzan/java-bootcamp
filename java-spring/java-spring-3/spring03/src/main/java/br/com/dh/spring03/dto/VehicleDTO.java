package br.com.dh.spring03.dto;

import br.com.dh.spring03.model.Vehicle;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VehicleDTO implements Serializable {

    private String plate;
    private String model;

    public VehicleDTO(Vehicle vehicle) {
        this.plate = vehicle.getPlate();
        this.model = vehicle.getModel();
    }
}
