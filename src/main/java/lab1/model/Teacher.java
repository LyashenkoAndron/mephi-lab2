package lab1.model;

import java.util.HashMap;
import java.util.List;

public class Teacher extends Person {
    private Lesson lesson;
    private int hours;

    public Teacher() {
        super(null, 0, null);
    }

    public Teacher(String name, int age, String phone, Lesson lesson, int hours) {
        super(name, age, phone);
        this.lesson = lesson;
        this.hours = hours;
    }

    public static Teacher createTeacher(String name, int age, String phone, Lesson lesson, int hours) {
        Teacher tc = new Teacher(name, age, phone, lesson, hours);
        g_id++;
        return tc;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fullName='" + fullName + '\'' +
                ", birth_year=" + birthYear +
                ", phone_number='" + phoneNumber + '\'' +
                ", lesson='" + lesson + +'\'' +
                ", hours=" + hours +
                '}';
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }
}
