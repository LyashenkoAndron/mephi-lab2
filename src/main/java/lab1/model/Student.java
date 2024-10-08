package lab1.model;

import java.util.HashMap;
import java.util.List;

public class Student extends Person {
    private List<Lesson> lessons;
    private HashMap<Lesson, Double> grades;

    public Student() {
        super(null, 0, null);
    }

    public Student(String name, int age, String phone, List<Lesson> lessons, HashMap<Lesson, Double> grades) {
        super(name, age, phone);
        this.lessons = lessons;
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", birth_year=" + birth_year +
                ", phone_number='" + phone_number + '\'' +
                ", lessons=" + lessons + '\'' +
                ", grades=" + grades +
                '}';
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setGrades(HashMap<Lesson, Double> grades) {
        this.grades = grades;
    }

    public HashMap<Lesson, Double> getGrades() {
        return grades;
    }
}
