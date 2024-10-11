package lab1;

import lab1.Controller.Controller;
import lab1.DAO.Dao;
import lab1.DAO.PeopleDAO;
import lab1.Dispatcher.DispatcherQ;
import lab1.Service.PeopleService;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        Dao dao = new PeopleDAO();

        PeopleService service = new PeopleService(dao);
        File file = new File("commands");
        Controller controller = new Controller(file, queue);

        Thread controllerThread = new Thread(controller);
        controllerThread.start();

        DispatcherQ dispatcher = new DispatcherQ(queue, service);
        Thread dispatcherThread = new Thread(dispatcher);
        dispatcherThread.start();
    }
}