package com.federicog.taskmanager.controller;

import com.federicog.taskmanager.exception.TaskNotFoundException;
import com.federicog.taskmanager.service.TaskService;
import com.federicog.taskmanager.view.TaskView;

import java.util.Scanner;

public class TaskController {

    private final TaskView taskView;
    private final TaskService taskService;

    public TaskController(TaskView taskView, TaskService taskService) {
        this.taskView = taskView;
        this.taskService = taskService;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                taskView.showMenu();
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> {
                        taskView.showTasks(taskService.getTasks());
                    }
                    case 2 -> {
                        taskView.showMessageInfo("Title: ");
                        String title = scanner.nextLine();
                        taskView.showMessageInfo("Description: ");
                        String description = scanner.nextLine();
                        taskService.addTask(title, description);
                        taskView.showMessageSuccess("Task added!");
                    }
                    case 3 -> {
                        taskView.showMessageInfo("Task ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        try {
                            taskService.completeTaskById(id);
                            taskView.showMessageSuccess("Task completed!");
                        } catch (TaskNotFoundException e) {
                            taskView.showError(e.getMessage());
                        }
                    }
                    case 0 -> {
                        taskView.showMessageInfo("Goodbye!");
                        return;
                    }
                    default -> taskView.showError("Invalid option.");
                }
            }
        }
    }

}
