package lab1.Dispatcher;

import lab1.Service.PeopleService;
import lab1.model.Lesson;
import lab1.model.Student;
import lab1.model.Teacher;

import java.util.*;
import java.util.concurrent.BlockingQueue;

public class DispatcherQ implements Runnable {
    private BlockingQueue<String> queue;
    private PeopleService service;

    public DispatcherQ(BlockingQueue<String> queue, PeopleService service) {
        this.queue = queue;
        this.service = service;
    }

    private void getCommand(String Command) {
        String[] command = Command.split(" ");
        String operation = command[0];
        System.out.println(operation);

        switch (operation) {
            // add teacher Elena 1 888 History 12
            case "add":
                if (Objects.equals(command[1], "teacher")) {
                    Teacher teacher = Teacher.createTeacher(command[2], Integer.parseInt(command[3]),
                            command[4], Lesson.valueOf(command[5].toUpperCase()), Integer.parseInt(command[6]));
                    service.savePerson(teacher);
                } else if (Objects.equals(command[1], "student")) {
                    String[] lessons = command[5].split(",");

                    // PE,CS,HISTORY
                    List<Lesson> lessonList = new ArrayList<>();
                    for (String lesson : lessons) {
                        lessonList.add(Lesson.valueOf(lesson.toUpperCase()));
                    }

                    // PE:3.4,CS:5.0
                    String[] averageMarks = command[6].split(",");
                    HashMap<Lesson, Double> averageMarksMap = new HashMap<>();
                    for (String mark : averageMarks) {
                        String[] marks = mark.split(":");
                        averageMarksMap.put(Lesson.valueOf(marks[0].toUpperCase()), Double.parseDouble(marks[1]));
                    }

                    Student student = Student.createStudent(command[2], Integer.parseInt(command[3]),
                            command[4], lessonList, averageMarksMap);

                    service.savePerson(student);
                }
                break;

            // remove 12
            case "remove":
                service.deletePerson(Integer.parseInt(command[1]));
                break;

            // hetById 3
            case "getById":
                service.getPersonById(Integer.parseInt(command[1]));

                break;

            // update 3 student Elena 1 888 History,PE,CS PE:5.0,CS:3.1
            case "update":
                if (Objects.equals(command[2], "teacher")) {
                    Teacher teacher = new Teacher(command[3], Integer.parseInt(command[4]),
                            command[5], Lesson.valueOf(command[6].toUpperCase()), Integer.parseInt(command[7]));
                    service.updatePerson(Integer.parseInt(command[1]), teacher);
                } else if (Objects.equals(command[2], "student")) {
                    String[] lessons = command[6].split(",");

                    // PE,CS,HISTORY
                    List<Lesson> lessonList = new ArrayList<>();
                    for (String lesson : lessons) {
                        lessonList.add(Lesson.valueOf(lesson.toUpperCase()));
                    }

                    // PE:3.4,CS:5.0
                    String[] averageMarks = command[7].split(",");
                    HashMap<Lesson, Double> averageMarksMap = new HashMap<>();
                    for (String mark : averageMarks) {
                        String[] marks = mark.split(":");
                        averageMarksMap.put(Lesson.valueOf(marks[0].toUpperCase()), Double.parseDouble(marks[1]));
                    }

                    Student student = new Student(command[3], Integer.parseInt(command[4]),
                            command[5], lessonList, averageMarksMap);

                    service.updatePerson(Integer.parseInt(command[1]), student);
                }
                break;

            default:
                System.out.println("Invalid command");
                break;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String command = queue.take();
                getCommand(command);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
