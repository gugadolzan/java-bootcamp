package exercise02.classes;

public class PdfBook extends Document {

    private int numberOfPages;
    private String author;
    private String title;
    private String genre;

    public PdfBook(
        String id,
        int numberOfPages,
        String author,
        String title,
        String genre
    ) {
        super(id);
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "PdfBook{" +
                "numberOfPages=" + numberOfPages +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
