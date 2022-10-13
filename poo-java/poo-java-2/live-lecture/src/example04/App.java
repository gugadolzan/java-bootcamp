package example04;

public class App {

    public static void main(String[] args) {
        Watch watch1 = new Watch(10, 20, 30);
        Watch watch2 = new Watch(11, 22, 33);

        Watch.setBrand("Casio");

        System.out.println(watch1.showInfo());
        System.out.println(watch2.showInfo());
    }

}
