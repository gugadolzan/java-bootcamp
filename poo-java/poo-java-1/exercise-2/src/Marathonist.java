public class Marathonist {

    private int code;
    private String id;
    private String name;
    private String surname;
    private int age;
    private String cell;
    private String emergencyContact;
    private String bloodType;

    public Marathonist() {}

    public Marathonist(
        String id,
        String name,
        String surname,
        int age,
        String cell,
        String emergencyContact,
        String bloodType
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cell = cell;
        this.emergencyContact = emergencyContact;
        this.bloodType = bloodType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return "Marathonist{" +
                "code=" + code +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", cell='" + cell + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
