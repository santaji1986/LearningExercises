package com.san.design;

public class Company extends ETVPark {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(String name, Garden garden) {
        super(garden);
        this.name = name;
    }

    public Company(String name, Cafeteria cafeteria) {
        super(cafeteria);
        this.name = name;
    }

    public Company(String name, Garden garden, Cafeteria cafeteria) {
        super(garden, cafeteria);
        this.name = name;
    }

}
