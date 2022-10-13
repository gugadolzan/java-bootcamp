package example05;

public class Example05 {

    public static void main(String[] args) {
        int[] vector = new int[3];

        vector[0] = 1;
        vector[1] = 2;
        vector[2] = 3;

        final int ZERO = 0;

        try {
            for (int i = 0; i < 4; i++) {
                System.out.println(vector[i] / ZERO);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("Finally");
        }

        System.out.println("End");
    }

}
