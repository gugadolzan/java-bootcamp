package example04;

public class Example04 {
    public static void main(String[] args) {
        int[] vector = new int[10];

        vector[0] = 5;

        for (int i = 0; i < vector.length; i++) {
            vector[i] = i;
        }

        for (int i = vector.length - 1; i >= 0; i--) {
            System.out.print(vector[i] + " ");
        }
    }
}
