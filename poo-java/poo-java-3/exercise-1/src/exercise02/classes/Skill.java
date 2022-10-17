package exercise02.classes;

public class Skill {

    private String description;

    public Skill(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "description='" + description + '\'' +
                '}';
    }
}
