package example01;

public abstract class Shape {

    private int x, y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void print();

    public abstract String getName();

    public abstract void show(Print print);

}
