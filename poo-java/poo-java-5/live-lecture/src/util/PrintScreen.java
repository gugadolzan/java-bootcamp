package util;

public class PrintScreen implements Print {
    @Override
    public void print(String data) {
        System.out.println("Printing to screen...");
        System.out.println(data);
    }
}
