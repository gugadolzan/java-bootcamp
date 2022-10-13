package example03;

public class Student extends Person {

    public Student(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }

}
