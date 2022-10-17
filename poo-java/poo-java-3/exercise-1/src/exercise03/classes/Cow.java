package exercise03.classes;

import exercise03.interfaces.Herbivore;

public class Cow extends Animal implements Herbivore {

    public Cow(String name, String race) {
        super(name, race);
    }

    @Override
    public void makeSound() {
        System.out.println("Moo!");
    }

    @Override
    public void eatPlants() {
        System.out.println("Cow eats plants");
    }
}
