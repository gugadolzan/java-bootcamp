package util;

public class PrintOnScreen implements Print {

    @Override
    public void print(String data) {
        System.out.println("Printing to screen...");
        System.out.println(data);
    }

}
