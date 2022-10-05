package example01;

public class AppBook {
    public static void main(String[] args) {
        Book myBbook = new Book();

        myBbook.title = "The Lord of the Rings";
        myBbook.author = "J.R.R. Tolkien";

        System.out.println("Title: " + myBbook.title);
    }
}
