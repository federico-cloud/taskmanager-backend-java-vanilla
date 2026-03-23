package com.federicog.taskmanager.service;

import com.federicog.taskmanager.exception.TaskNotFoundException;
import com.federicog.taskmanager.model.Task;
import com.federicog.taskmanager.model.TaskStatus;
import com.federicog.taskmanager.util.JsonUtil;

import java.util.List;

public class TaskService {
    private List<Task> tasks;

    public TaskService() {
        this.tasks = JsonUtil.loadTasks();
    }

    public void addTask(String title, String description) {
        int id = tasks.size() + 1;
        Task task = new Task(id, title, description, TaskStatus.PENDING);
        tasks.add(task);
        JsonUtil.saveTasks(tasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new TaskNotFoundException(id);
    }

    public void completeTaskById(int id) {
       Task task = findTaskById(id);
       task.setStatus(TaskStatus.COMPLETED);
        JsonUtil.saveTasks(tasks);
    }

}