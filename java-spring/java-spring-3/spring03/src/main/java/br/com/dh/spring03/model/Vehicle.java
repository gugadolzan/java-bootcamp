package br.com.dh.spring03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle implements Comparable<Vehicle> {

    private String plate;
    private String model;
    private int year;
    private double value;

    @Override
    public int compareTo(Vehicle o) {
        if (this.value > o.getValue()) {
            return 1;
        }
        if (this.value < o.getValue()) {
            return -1;
        }
        return 0;
    }
}
