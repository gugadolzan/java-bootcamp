package exercise03.classes;

import exercise03.interfaces.Carnivore;

public class Dog extends Animal implements Carnivore {

    public Dog(String name, String race) {
        super(name, race);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public void eatMeat() {
        System.out.println("Dog eats meat");
    }
}
