package lab1.model;

public abstract class Person {
    protected static int g_id = 0;
    protected int id;
    protected String fullName;
    protected int birth_year;
    protected String phone_number;

    public Person(String fullName, int birth_year, String phone_number) {
        this.id = ++g_id;
        this.fullName = fullName;
        this.birth_year = birth_year;
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", birth_year=" + birth_year +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public int getBirthYear() {
        return birth_year;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
