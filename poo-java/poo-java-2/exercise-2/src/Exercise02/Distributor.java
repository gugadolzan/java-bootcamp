package Exercise02;

public class Distributor {
    public static void main(String[] args) {
        Product[] products = new Product[4];

        products[0] = new NonPerishable("Coke", 1.5, "Drink");
        products[1] = new NonPerishable("Pepsi", 1.5, "Drink");
        products[2] = new Perishable("Milk", 1.5, 3);
        products[3] = new Perishable("Cheese", 1.5, 5);

        double total = 0;

        for (Product product : products) {
            total += product.calculateTotalPrice(5);
        }

        System.out.println("Total = " + total);
    }
}
