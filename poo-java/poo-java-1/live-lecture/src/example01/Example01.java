package example01;

public class Example01 {
    public static void main(String[] args) {
        int intNumber;
        double doubleNumber;

        intNumber = 12;

        doubleNumber = intNumber;

        System.out.println(intNumber);
        System.out.println(doubleNumber);

        doubleNumber = 4.5;

        intNumber = (int) doubleNumber; // casting

        System.out.println(intNumber);
        System.out.println(doubleNumber);

        double sum = intNumber + doubleNumber;

        System.out.println("Total = " + sum);
    }
}
