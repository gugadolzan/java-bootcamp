package exercise03;

import exercise03.classes.Cat;
import exercise03.classes.Cow;
import exercise03.classes.Dog;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Rayka", "Husky");
        Cat cat = new Cat("Maca", "Persian");
        Cow cow = new Cow("Manka", "Holstein");

        dog.makeSound();
        dog.eatMeat();

        cat.makeSound();
        cat.eatMeat();

        cow.makeSound();
        cow.eatPlants();
    }
}
