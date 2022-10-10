import java.util.ArrayList;

public class Garage {
    private int id;
    private ArrayList<Vehicle> vehicles;

    public Garage(int id, ArrayList<Vehicle> vehicles) {
        this.id = id;
        this.vehicles = vehicles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Vehicle> sortByPrice() {
        ArrayList<Vehicle> vehicles = new ArrayList<>(this.vehicles);
        vehicles.sort((v1, v2) -> v1.getPrice() - v2.getPrice());
        return vehicles;
    }

    public ArrayList<Vehicle> sortByBrand() {
        ArrayList<Vehicle> vehicles = new ArrayList<>(this.vehicles);
        vehicles.sort((v1, v2) -> v1.getBrand().compareTo(v2.getBrand()));
        return vehicles;
    }

    public ArrayList<Vehicle> priceUnder1000() {
        ArrayList<Vehicle> vehicles = new ArrayList<>(this.vehicles);
        vehicles.removeIf(v -> v.getPrice() > 1000);
        return vehicles;
    }

    public ArrayList<Vehicle> priceOver1000() {
        ArrayList<Vehicle> vehicles = new ArrayList<>(this.vehicles);
        vehicles.removeIf(v -> v.getPrice() <= 1000);
        return vehicles;
    }

    public double averagePrice() {
        double averagePrice = vehicles.stream().mapToInt(Vehicle::getPrice).average().orElse(0);
        return Math.round(averagePrice * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", vehicles=" + vehicles +
                '}';
    }
}
