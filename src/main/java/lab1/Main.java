package lab1;

import lab1.Controller.Controller;
import lab1.DAO.CachedPeopleDAO;
import lab1.DAO.Dao;
import lab1.DAO.PeopleDAO;
import lab1.Dispatcher.DispatcherQ;
import lab1.Service.PeopleService;
import lab1.model.Lesson;
import lab1.model.Student;
import lab1.model.Teacher;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        Dao dao = new PeopleDAO();

        PeopleService service = new PeopleService(dao);
        File file = new File("commandsfolder");
        Controller controller = new Controller(file, queue);

        Thread controllerThread = new Thread(controller);
        controllerThread.start();

        DispatcherQ dispatcher = new DispatcherQ(queue, service);
        Thread dispatcherThread = new Thread(dispatcher);
        dispatcherThread.start();


        /*List<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(Lesson.CS);
        lessons.add(Lesson.PE);
        Teacher teacher = Teacher.createTeacher("Elena", 26, "0", Lesson.CS, 12);
        Teacher teacher2 = Teacher.createTeacher("Elena", 26, "0", Lesson.CS, 12);
        Student student = Student.createStudent("Hui", 26, "0", lessons, null);
        Student student2 = new Student("Hui", 44, "0", lessons, null);


        PeopleDAO PeopleDAO = new PeopleDAO();
        PeopleDAO.save(teacher);
        PeopleDAO.save(teacher2);
        PeopleDAO.save(student);
        System.out.printf(PeopleDAO.findById(3).getPhoneNumber());
        PeopleDAO.update(student.getId(), student2);
        Teacher teacher3 = Teacher.createTeacher("Elena", 66, "0", Lesson.CS, 12);
        System.out.printf(PeopleDAO.findById(3).toString());
        PeopleDAO.update(3, student2);
        PeopleDAO.save(teacher3);*/
    }
}