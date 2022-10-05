package exercise02.classes;

public abstract class Document {
    private String id;

    public Document(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                '}';
    }
}
