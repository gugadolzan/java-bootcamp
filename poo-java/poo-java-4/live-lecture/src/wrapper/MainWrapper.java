package wrapper;

public class MainWrapper {

    public static void main(String[] args) {
        int number1 = 10;
        Integer number2 = 15; // Autoboxing

        number1 = number2; // Unboxing

        System.out.println(number1);
        System.out.println(number2);

        // int value = Integer.parseInt("123");
        // String text = Integer.toString(123);
        // String text = 123 + "";

        Integer n1 = 200;
        Integer n2 = 200;

        System.out.println(n1 == n2); // false
        System.out.println(n1.equals(n2)); // true
    }

}
