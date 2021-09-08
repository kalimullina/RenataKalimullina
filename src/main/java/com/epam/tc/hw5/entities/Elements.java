package com.epam.tc.hw7.entities;

public enum Elements {

    WATER(1, "Water"),
    EARTH(2, "Earth"),
    WIND(3, "Wind"),
    FIRE(4, "Fire");

    private final int number;
    private final String name;


    Elements(int number, String name) {
        this.name = name;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
