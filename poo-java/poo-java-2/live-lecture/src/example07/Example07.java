package example07;

import java.util.Scanner;

public class Example07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        String data;
        String name;

        System.out.print("Enter an integer number: ");
        // number = scanner.nextInt();
        data = scanner.nextLine();
        number = Integer.parseInt(data);

        System.out.print("Enter your name: ");
        // scanner.nextLine();
        name = scanner.nextLine();

        System.out.println("You entered: " + number);
        System.out.println("Your name is: " + name);

        scanner.close();
    }
}
