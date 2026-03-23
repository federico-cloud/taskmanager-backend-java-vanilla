package com.federicog.taskmanager;

import com.federicog.taskmanager.controller.TaskController;
import com.federicog.taskmanager.service.TaskService;
import com.federicog.taskmanager.util.Config;
import com.federicog.taskmanager.util.SchemaValidator;
import com.federicog.taskmanager.view.TaskView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        File dataDir = new File("data");
        dataDir.mkdirs();

        // 1. Si el archivo no existe, crearlo vacío
        File file = new File(Config.FILE_PATH);
        if (!file.exists()) {
            Files.writeString(Paths.get(Config.FILE_PATH), "[]");
        }

        // 2. Validar el archivo antes de arrancar
        if (!SchemaValidator.validate(Config.FILE_PATH)) {
            System.out.println("Invalid tasks.json. Please fix it and try again.");
            return;
        }

        // 3. Instanciar las tres capas y arrancar
        TaskView view = new TaskView();
        TaskService service = new TaskService();
        TaskController controller = new TaskController(view, service);
        controller.start();
    }
}