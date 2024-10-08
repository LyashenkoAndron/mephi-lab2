package lab1.model;

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

    @Override
    public String toString() {
        return "Teacher{" +
                "fullName='" + fullName + '\'' +
                ", birth_year=" + birth_year +
                ", phone_number='" + phone_number + '\'' +
                ", lesson='" + lesson + + '\'' +
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
