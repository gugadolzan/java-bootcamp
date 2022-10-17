package example02;

public class Example02 {

    public static void main(String[] args) {
        int number = 5;

        if (number > 0) {
            System.out.println("Number is positive");
        } else {
            if (number < 0) {
                System.out.println("Number is negative");
            } else {
                System.out.println("Number is zero");
            }
        }
    }
}
