package com.epam.tc.hw5.entities;

public enum User {

    ROMAN("Roman", "Jdi1234", "ROMAN IOVLEV");

    private final String login;
    private final String password;
    private final String fullName;

    User(String login, String password, String fullName) {
        this.login = login;

        this.password = password;
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
