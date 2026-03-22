package com.federicog.taskmanager.model;

public class Task {
    //ATTRIBUTES
    private int id;
    private String title;
    private String description;
    private TaskStatus status;

    //NO ARGS CONSTRUCTOR
    public Task(){}

    //FULL ARGS CONSTRUCTOR
    public Task(int id, String title, String description, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

   //SETTERS
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
