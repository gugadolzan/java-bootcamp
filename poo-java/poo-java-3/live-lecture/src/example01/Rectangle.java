package example01;

public class Rectangle extends Shape {

    public Rectangle(int x, int y) {
        super(x, y);
    }

    @Override
    public void print() {
        System.out.println("Rectangle");
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public void show(Print print) {
        print.print(getName());
    }
}
