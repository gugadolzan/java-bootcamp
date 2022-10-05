package exercise02.interfaces;

import exercise02.classes.Document;

public interface Printable {
    static void printDocument(Document document) {
        System.out.println(document);
    }
}
