package com.epam.tc.hw6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "a[href='#']")
    private WebElement dropDownBeforeLogin;

    @FindBy(xpath = "//*[@id='name']")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    /*@Step("Open test site by URL")
    public void openPage(WebDriver webDriver) {
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }*/

    /*public void open() {
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }*/

    @Step("Assert Browser title")
    public String getTittle(WebDriver webDriver) {
        return webDriver.getTitle();
    }

    @Step("Login as user with {name} and {password}")
    public void login(String name, String password) {
        dropDownBeforeLogin.click();
        userName.sendKeys(name);
        userPassword.sendKeys(password);
        loginButton.click();
    }
}
