public class Person {

    private String name;
    private int age;
    private String id;
    private double weight;
    private double height;

    public Person() {
    }

    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person(String name, int age, String id, double weight, double height) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int calculateBMI() {
        double BMI = weight / Math.pow(height, 2);
        if (BMI < 20) {
            return -1;
        } else if (BMI < 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

}
