package example01;

public class AppBook {

    public static void main(String[] args) {
        Book myBook = new Book();

        myBook.title = "The Lord of the Rings";
        myBook.author = "J.R.R. Tolkien";

        System.out.println("Title: " + myBook.title);
    }
}
