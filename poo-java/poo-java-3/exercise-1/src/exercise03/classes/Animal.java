package exercise03.classes;

public abstract class Animal {

    private String name;
    private String race;

    public Animal(String name, String race) {
        this.name = name;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                '}';
    }

    public abstract void makeSound();
}
