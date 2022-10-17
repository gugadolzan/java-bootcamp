package util;

public class PrintOnPrinter implements Print {

    @Override
    public void print(String data) {
        System.out.println("Printing to printer...");
        System.out.println(data);
    }
}
