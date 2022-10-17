package Exercise02;

public class Perishable extends Product {

    private int daysToExpire;

    public Perishable(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "daysToExpire=" + daysToExpire +
                '}';
    }

    @Override
    public double calculateTotalPrice(int quantity) {
        if (daysToExpire <= 3) {
            return super.calculateTotalPrice(quantity) / (5 - daysToExpire);
        }
        return super.calculateTotalPrice(quantity);
    }
}
