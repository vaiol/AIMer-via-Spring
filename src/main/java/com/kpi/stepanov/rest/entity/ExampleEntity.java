package com.kpi.stepanov.rest.entity;

public class ExampleEntity {
    private int id;
    private String message;

    public ExampleEntity(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
