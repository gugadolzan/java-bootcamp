package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStream {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 22, 13, 4, 56, 36, 75, 58, 19, 10);

        Stream<Integer> stream = numbers.stream();

        System.out.println("Print all numbers");
        // stream.forEach(n -> System.out.print(n));
        stream.forEach(System.out::print);

        System.out.println();
        System.out.println("Print even numbers");
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        System.out.println("Sorted numbers");
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }

}
