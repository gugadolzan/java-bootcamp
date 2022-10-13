package stream2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> people = Data.getPeople();

        people.stream()
                .filter(p -> p.getCountry().equalsIgnoreCase("Brazil"))
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Sorted by age:");
        people.stream()
                .filter(p -> p.getCountry().equalsIgnoreCase("Brazil"))
                .limit(10)
                .sorted()
                .forEach(System.out::println);

        System.out.println("Sorted by name:");
        people.stream()
                .filter(p -> p.getCountry().equalsIgnoreCase("Brazil"))
                .limit(10)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);

        double averageAge = people.stream()
                .mapToDouble(Person::getAge)
                .average().getAsDouble();

        System.out.println("Average age: " + averageAge);
    }

}
