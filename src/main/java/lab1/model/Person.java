package lab1.model;

import com.fasterxml.jackson.annotation.*;

import java.io.File;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type" // Имя поля, которое будет добавлено в JSON
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Teacher.class, name = "teacher"),
        @JsonSubTypes.Type(value = Student.class, name = "student")
})

public abstract class Person {
    protected static int g_id = 0;

    protected int id = 0;
    protected String fullName;
    protected int birthYear;
    protected String phoneNumber;

    public Person(String fullName, int birth_year, String phone_number) {
        if (g_id == 0) {
            g_id = getG_id();
        }

        this.id = g_id;
        this.fullName = fullName;
        this.birthYear = birth_year;
        this.phoneNumber = phone_number;
    }

    protected int getG_id() {
        File dir = new File("data");
        File[] files = dir.listFiles();
        int max = 0;

        if (dir.exists() && dir.isDirectory()) {
            assert files != null;
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".json")) {
                    String fileName = file.getName().replace(".json", ""); // Удаляем .json
                    try {
                        int id = Integer.parseInt(fileName);
                        if (id > max) {
                            max = id;
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (max > 0) {
            return max + 1; // Возвращаем максимальный ID, если файлов нет, возвращаем -1
        }
        return max;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", birth_year=" + birthYear +
                ", phone_number='" + phoneNumber + '\'' +
                '}';
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setBirth_year(int birth_year) {
        this.birthYear = birth_year;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setPhone_number(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
