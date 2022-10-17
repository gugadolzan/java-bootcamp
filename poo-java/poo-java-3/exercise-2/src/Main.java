import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle("Fiesta", "Ford", 1000));
        vehicles.add(new Vehicle("Focus", "Ford", 1200));
        vehicles.add(new Vehicle("Explorer", "Ford", 2500));
        vehicles.add(new Vehicle("Uno", "Fiat", 500));
        vehicles.add(new Vehicle("Cronos", "Fiat", 1000));
        vehicles.add(new Vehicle("Torino", "Fiat", 1250));
        vehicles.add(new Vehicle("Aveo", "Chevrolet", 1250));
        vehicles.add(new Vehicle("Spin", "Chevrolet", 2500));
        vehicles.add(new Vehicle("Corolla", "Toyota", 1200));
        vehicles.add(new Vehicle("Fortuner", "Toyota", 3000));
        vehicles.add(new Vehicle("Logan", "Renault", 950));

        Garage garage = new Garage(1, vehicles);

        System.out.println("Vehicles sorted by price: " + garage.sortByPrice());
        System.out.println("Vehicles sorted by brand: " + garage.sortByBrand());
        System.out.println(
            "Vehicles with price under 1000: " + garage.priceUnder1000()
        );
        System.out.println(
            "Vehicles with price over 1000: " + garage.priceOver1000()
        );
        System.out.println("Average price: " + garage.averagePrice());
    }
}
