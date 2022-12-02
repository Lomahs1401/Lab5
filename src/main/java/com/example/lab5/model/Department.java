package com.example.lab5.model;

public class Department {
    private int id;
    private String room;
    private String name;

    public Department(int id, String room, String name) {
        this.id = id;
        this.room = room;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
