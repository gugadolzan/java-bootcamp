package example01;

public class AppShape {

    public static void main(String[] args) {
        Square square = new Square(1, 2);
        Shape square2 = new Square(3, 4);
        // Shape shape = new Shape(5, 6); 'Shape' is abstract; cannot be instantiated

        square.print();

        Shape[] shapes = new Shape[3];
        shapes[0] = new Square(1, 1);
        shapes[1] = new Square(2, 2);
        shapes[2] = new Rectangle(3, 4);

        for (Shape shape : shapes) {
            System.out.print("for loop: ");
            shape.print();
        }

        GeneratePdf.generate(shapes[1]);
        GeneratePdf.generate(shapes[2]);

        PrintOnScreen screen = new PrintOnScreen();
        PrintOnPrinter printer = new PrintOnPrinter();

        shapes[0].show(screen);
        shapes[1].show(printer);
    }

}
