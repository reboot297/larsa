package com.reboot297.larsa.model;

public class Device {

    private String id;
    private String name;

    private final String model;

    public Device(String id, String model) {
        this.id = id;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return getId() +  " " + getModel();
    }
}
