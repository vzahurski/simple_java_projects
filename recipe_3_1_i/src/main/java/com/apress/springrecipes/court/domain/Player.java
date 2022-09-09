package com.apress.springrecipes.court.domain;

// Объект предметной области Игрок
// в пакете domain определяем сущности-объекты предметной области

public class Player {

    private String name;
    private String phone;

    public Player() {
    }

    public Player(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
