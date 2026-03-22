package com.federicog.taskmanager.model;

public enum TaskStatus {
    PENDING("Pending"),
    COMPLETED("Completed");

    private final String label;

    TaskStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
