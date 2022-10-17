package example01;

public class PrintOnScreen implements Print {

    public void print(String name) {
        System.out.println("Print on screen " + name);
    }
}
