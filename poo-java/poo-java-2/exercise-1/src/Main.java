public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("John", 25, "123456789");
        Person person3 = new Person("John", 25, "123456789", 80, 1.8);
        // Person person4 = new Person("John", 25); Cannot resolve constructor 'Person(String, int)'

        System.out.println(person3);

        int person3BMI = person3.calculateBMI();

        if (person3BMI == -1) {
            System.out.println(person3.getName() + " is underweight");
        }
        if (person3BMI == 0) {
            System.out.println(person3.getName() + " is normal weight");
        }
        if (person3BMI == 1) {
            System.out.println(person3.getName() + " is overweight");
        }

        if (person3.isAdult()) {
            System.out.println(person3.getName() + " is an adult");
        } else {
            System.out.println(person3.getName() + " is not an adult");
        }
    }
}
