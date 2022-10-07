package example02;

import java.util.ArrayList;
import java.util.List;

public class AppPerson {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("John"));
        persons.add(new Person("Jane"));
        persons.add(new Person("Jack"));

        System.out.println(persons);

        System.out.println(persons.get(1));
    }
}
