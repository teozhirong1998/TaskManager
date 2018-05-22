package com.example.a16022635.taskmanager;

import java.io.Serializable;

public class Task implements Serializable {

    private int id;
    private String name;
    private String description;
    private int seconds;

    public Task(int id, String name, String description, int seconds) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", seconds=" + seconds +
                '}';
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setDescription(String description) { this.description = description; }
}
