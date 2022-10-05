package exercise03.classes;

import exercise03.interfaces.Carnivore;

public class Cat extends Animal implements Carnivore {
    public Cat(String name, String race) {
        super(name, race);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public void eatMeat() {
        System.out.println("Cat eats meat");
    }
}
