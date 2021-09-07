package com.epam.tc.hw5.entities;

public class UserTableValue {

    private final Integer number;
    private final String user;
    private final String description;

    public UserTableValue(Integer number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }
}
