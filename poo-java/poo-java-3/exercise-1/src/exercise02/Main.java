package exercise02;

import exercise02.classes.*;
import exercise02.interfaces.Printable;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("John");

        Skill skill1 = new Skill("Java");
        Skill skill2 = new Skill("TypeScript");
        List<Skill> skills = List.of(skill1, skill2);

        Curriculum curriculum = new Curriculum("CURR1", person, skills);
        Printable.printDocument(curriculum);

        PdfBook pdfBook = new PdfBook("PDF1", 100, "John", "Java", "Programming");
        Printable.printDocument(pdfBook);

        Report report = new Report("REP1", "This is a report", 10, "John", "Jane");
        Printable.printDocument(report);
    }

}
