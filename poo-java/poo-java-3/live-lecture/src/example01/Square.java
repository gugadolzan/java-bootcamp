package example01;

public class Square extends Shape {

    public Square(int x, int y) {
        super(x, y);
    }

    @Override
    public void print() {
        System.out.println("Square");
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public void show(Print print) {
        print.print(getName());
    }

}
