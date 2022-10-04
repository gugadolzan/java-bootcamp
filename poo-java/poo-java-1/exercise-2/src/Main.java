import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create marathonists
        Marathonist m1 = new Marathonist("123456789", "Eddie", "Munson", 20, "123456789", "987654321", "A+");
        Marathonist m2 = new Marathonist("987654321", "Max", "Mayfield", 15, "987654321", "123456789", "B+");
        Marathonist m3 = new Marathonist("135792468", "Billy", "Hargrove", 18, "135792468", "246813579", "AB+");
        Marathonist m4 = new Marathonist("246813579", "Dustin", "Henderson", 14, "246813579", "135792468", "O+");

        // Create circuits
        final Circuit beginnerCircuit = new Circuit(Category.BEGINNER, 10);
        final Circuit intermediateCircuit = new Circuit(Category.INTERMEDIATE, 20);
        final Circuit advancedCircuit = new Circuit(Category.ADVANCED, 30);

        // Create registrations for beginner circuit
        Registration r1 = new Registration(Category.BEGINNER, m1);
        Registration r2 = new Registration(Category.BEGINNER, m2);
        Registration r3 = new Registration(Category.BEGINNER, m3);
        Registration r4 = new Registration(Category.BEGINNER, m4);

        // Create registrations for intermediate circuit
        Registration r5 = new Registration(Category.INTERMEDIATE, m1);
        Registration r6 = new Registration(Category.INTERMEDIATE, m2);
        Registration r7 = new Registration(Category.INTERMEDIATE, m3);
        Registration r8 = new Registration(Category.INTERMEDIATE, m4);

        // Create registrations for advanced circuit
        Registration r9 = new Registration(Category.ADVANCED, m1);
        Registration r10 = new Registration(Category.ADVANCED, m2);
        Registration r11 = new Registration(Category.ADVANCED, m3);
        Registration r12 = new Registration(Category.ADVANCED, m4);

        // Add registrations to beginner circuit
        System.out.println("********    ADDING REGISTRATION TO BEGINNER CIRCUIT");
        beginnerCircuit.addRegistration(r1);
        beginnerCircuit.addRegistration(r2);
        beginnerCircuit.addRegistration(r3);
        beginnerCircuit.addRegistration(r4);

        System.out.println();

        // Add registrations to intermediate circuit
        System.out.println("********    ADDING REGISTRATION TO INTERMEDIATE CIRCUIT");
        intermediateCircuit.addRegistration(r5);
        intermediateCircuit.addRegistration(r6);
        intermediateCircuit.addRegistration(r7);
        intermediateCircuit.addRegistration(r8);

        System.out.println();

        // Add registrations to advanced circuit
        System.out.println("********    ADDING REGISTRATION TO ADVANCED CIRCUIT");
        advancedCircuit.addRegistration(r9);
        advancedCircuit.addRegistration(r10);
        advancedCircuit.addRegistration(r11);
        advancedCircuit.addRegistration(r12);

        System.out.println();

        // Add duplicate registration
        System.out.println("********    ADDING DUPLATE REGISTRATION");
        beginnerCircuit.addRegistration(r1);
        System.out.println(beginnerCircuit.toString());

        System.out.println();

        // Remove registration
        System.out.println("********    REMOVING REGISTRATION");
        beginnerCircuit.removeRegistration(1);
        System.out.println();

        // Show registrations per circuit
        System.out.println("********    REGISTRATIONS PER CIRCUIT");
        System.out.println(beginnerCircuit);
        System.out.println(intermediateCircuit);
        System.out.println(advancedCircuit);

        // Add circuits to jungle marathon
        ArrayList<Circuit> circuits = new ArrayList<>();
        circuits.add(beginnerCircuit);
        circuits.add(intermediateCircuit);
        circuits.add(advancedCircuit);

        JungleMarathon jungleMarathon = new JungleMarathon(circuits);
        System.out.println(jungleMarathon);
    }
}
