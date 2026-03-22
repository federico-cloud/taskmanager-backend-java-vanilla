package com.federicog.taskmanager.util;

import com.federicog.taskmanager.model.Task;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    public static List<Task> loadTasks() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader fileReader = new FileReader(Config.FILE_PATH)) {
            Type type = new TypeToken<List<Task>>() {
            }.getType();
            return gson.fromJson(fileReader, type);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void saveTasks(List<Task> tasks) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter(Config.FILE_PATH)) {
            gson.toJson(tasks, fileWriter);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
