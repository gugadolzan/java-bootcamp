import java.util.ArrayList;

public class JungleMarathon {

    final private ArrayList<Circuit> circuits;
    final private Double totalAmount;
    final private int totalRegistrations;

    public JungleMarathon(ArrayList<Circuit> circuits) {
        this.circuits = circuits;
        this.totalAmount = calculateTotalAmount();
        this.totalRegistrations = calculateTotalRegistrations();
    }

    public Double calculateTotalAmount() {
        Double totalAmount = 0.0;
        for (Circuit circuit : circuits) {
            for (Registration registration : circuit.getRegistrations()) {
                totalAmount += registration.getRegistrationFee();
            }
        }
        return totalAmount;
    }

    ;

    public int calculateTotalRegistrations() {
        int totalRegistrations = 0;
        for (Circuit circuit : circuits) {
            totalRegistrations += circuit.getRegistrations().size();
        }
        return totalRegistrations;
    }

    @Override
    public String toString() {
        return "JungleMarathon{" +
                "totalAmount=" + totalAmount +
                ", totalRegistrations=" + totalRegistrations +
                '}';
    }

}
