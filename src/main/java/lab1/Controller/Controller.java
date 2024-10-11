package lab1.Controller;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Controller implements Runnable {
    private final File commandDir;
    private final BlockingQueue<String> commands;

    public Controller(File commandDir, BlockingQueue<String> commands) {
        this.commandDir = commandDir;
        this.commands = commands;

        if (!commandDir.exists()) {
            commandDir.mkdir();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                File[] files = commandDir.listFiles();

                if (files != null) {
                    for (File file : files) {
                        String command = Files.readString(file.toPath());
                        commands.add(command);
                        Files.delete(file.toPath());
                    }
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
