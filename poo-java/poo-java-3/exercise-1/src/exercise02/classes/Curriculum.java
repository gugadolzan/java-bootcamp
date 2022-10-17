package exercise02.classes;

import java.util.List;

public class Curriculum extends Document {

    private Person person;
    private List<Skill> skills;

    public Curriculum(String id, Person person, List<Skill> skills) {
        super(id);
        this.person = person;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "person=" + person +
                ", skills=" + skills +
                '}';
    }
}
