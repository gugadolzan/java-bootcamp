package lambda;

import java.util.Arrays;
import java.util.List;

public class Example02 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.forEach(n -> System.out.print(n + " - "));
        System.out.println();

        for (int i = 0; i < numbers.size(); i++)
            System.out.print(numbers.get(i) + " - ");
        System.out.println();

        for (Integer n : numbers)
            System.out.print(n + " - ");
        System.out.println();
    }

}
