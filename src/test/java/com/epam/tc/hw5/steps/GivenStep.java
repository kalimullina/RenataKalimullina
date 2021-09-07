package com.epam.tc.hw5.steps;

import static com.epam.tc.hw5.entities.User.ROMAN;

import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {

    /*Ex1*/
    @Given("I open JDI GitHub site")
    public void openHomePage() {
        homePage.openHomePage();
    }

    @Given("I login as {string} with {string} password")
    public void loginAsUser(String name, String password) {
        homePage.login(name, password);
    }

    /*Ex2*/
    @Given("I login as user \"Roman Iovlev\"")
    public void loginAsRomanIovlev() {
        homePage.login(ROMAN.getLogin(), ROMAN.getPassword());
    }
}
