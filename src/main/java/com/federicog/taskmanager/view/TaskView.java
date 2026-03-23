package com.federicog.taskmanager.view;

import com.federicog.taskmanager.model.Task;

import java.util.List;

public class TaskView {

    public void showMenu() {
        System.out.println("=== Task Manager ===");
        System.out.println("1. List tasks");
        System.out.println("2. Add task");
        System.out.println("3. Complete tasks");
        System.out.println("4. Delete task");
        System.out.println("0. Exit");
        System.out.println("=======================");
        System.out.println("Choose an option:");
    }

    public void showTasks(List<Task> tasks) {
        for (Task task : tasks) {
            System.out.println("[" + task.getId() + "] " + task.getTitle() + " — " + task.getStatus().getLabel());
            System.out.println("    " + task.getDescription());
        }
    }

    public void showMessageSuccess(String message) {
        System.out.println("[SUCCESS] " + message);
    }

    public void showMessageInfo(String message) {
        System.out.println("[INFO] " + message);
    }

    public void showError(String message) {
        System.out.println("[ERROR] " + message);
    }
}