package example06;

public class Example06 {
    public static void main(String[] args) {
        try {
            System.out.println("Answer: " + divide(11, 0));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

}
