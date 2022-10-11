package stream2;

public class Person implements Comparable<Person> {
    private String name, country;
    private int age;
    private double amountSpent;

    public Person(String name, String country, int age, double amountSpent) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.amountSpent = amountSpent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(double amountSpent) {
        this.amountSpent = amountSpent;
    }

    @Override
    public String toString() {
        return name + "; " + age + "; " + country;
    }

    @Override
    public int compareTo(Person otherPerson) {
        if (this.age < otherPerson.getAge()) return -1;

        if (this.age > otherPerson.getAge()) return 1;

        return 0;
    }
}
