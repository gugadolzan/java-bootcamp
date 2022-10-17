package Exercise01;

public class ExceptionsExercise {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        // calculate1(a, b);
        calculate2(a, b);
    }

    public static void calculate1(int a, int b) {
        try {
            int c = b / a;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println("An error occurred");
        } finally {
            System.out.println("Program finished");
        }
    }

    public static void calculate2(int a, int b)
        throws IllegalArgumentException {
        try {
            int c = b / a;
            System.out.println(c);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Cannot divide by zero");
        } finally {
            System.out.println("Program finished");
        }
    }
}
