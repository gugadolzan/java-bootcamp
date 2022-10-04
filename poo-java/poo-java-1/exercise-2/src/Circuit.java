import java.util.ArrayList;

public class Circuit {
    private Category category;
    private int distance;
    private ArrayList<Registration> registrations;

    public Circuit(Category category, int distance) {
        this.category = category;
        this.distance = distance;
        this.registrations = new ArrayList<>();
    }

    private String marathonistName(Marathonist marathonist) {
        return marathonist.getName() + " " + marathonist.getSurname();
    }

    public void addRegistration(Registration registration) {
        if (registration.getCategory().equals(this.category)) {
            if (!(registration.getMarathonist().getAge() < 18 &&
                    registration.getCategory().equals(Category.ADVANCED))) {
                if (!registrations.contains(registration)) {
                    registration.getMarathonist().setCode(registrations.size() + 1);
                    this.registrations.add(registration);
                    System.out.println("Registration for " + this.marathonistName(registration.getMarathonist()) +
                            " in " + this.category + " category was successful.");
                } else {
                    System.out.println(this.marathonistName(registration.getMarathonist()) +
                            " is already registered.");
                }
            } else {
                System.out.println(this.marathonistName(registration.getMarathonist()) +
                        " is too young to register for the advanced category.");
            }
        } else {
            System.out.println("The registration is not for this category");
        }
    }

    public void removeRegistration(int code) {
        if (registrations.removeIf(registration -> registration.getMarathonist().getCode() == code)) {
            System.out.println("Registration removed successfully");
        } else {
            System.out.println("Registration not found");
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public ArrayList<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(ArrayList<Registration> registrations) {
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "Circuit{" +
                "category=" + category +
                ", distance=" + distance +
                ", registrations=" + registrations +
                '}';
    }
}
