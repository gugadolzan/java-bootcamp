package example02;

public class AppWatch {

    public static void main(String[] args) {
        Watch myWatch = new Watch(9, 12, 0);
        Watch myWatch2 = new Watch(17, 72, 0);

        myWatch.showTime();
        myWatch2.showTime();

        System.out.println("Minute: " + myWatch.getMinute());
        System.out.println("Minute: " + myWatch2.getMinute());
    }
}
