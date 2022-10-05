package exercise02.classes;

public class Report extends Document {
    private String content;
    private int numberOfPages;
    private String author;
    private String reviewer;

    public Report(String id, String content, int numberOfPages, String author, String reviewer) {
        super(id);
        this.content = content;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Report{" +
                "content='" + content + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", author='" + author + '\'' +
                ", reviewer='" + reviewer + '\'' +
                '}';
    }
}
