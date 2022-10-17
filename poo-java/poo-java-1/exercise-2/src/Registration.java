public class Registration {

    private Category category;
    private Marathonist marathonist;
    private Double registrationFee;

    public Registration(Category category, Marathonist marathonist) {
        this.category = category;
        this.marathonist = marathonist;
        this.registrationFee = calculateRegistrationFee();
    }

    private Double calculateRegistrationFee() {
        switch (this.category) {
            case BEGINNER:
                if (this.marathonist.getAge() < 18) {
                    return 1300.0;
                } else {
                    return 1500.0;
                }
            case INTERMEDIATE:
                if (this.marathonist.getAge() < 18) {
                    return 2000.0;
                } else {
                    return 2300.0;
                }
            case ADVANCED:
                return 2800.0;
            default:
                return 0.0;
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Marathonist getMarathonist() {
        return marathonist;
    }

    public void setMarathonist(Marathonist marathonist) {
        this.marathonist = marathonist;
    }

    public Double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Double registrationFee) {
        this.registrationFee = registrationFee;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "category=" + category +
                ", marathonist=" + marathonist +
                ", registrationFee=" + registrationFee +
                '}';
    }
}
