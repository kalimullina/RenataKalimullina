package com.epam.tc.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "a[href='#']")
    private WebElement dropDownBeforeLogin;

    @FindBy(xpath = "//*[@id='name']")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    public void openHomePage() {
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public void login(String name, String password) {
        dropDownBeforeLogin.click();
        userName.sendKeys(name);
        userPassword.sendKeys(password);
        loginButton.click();
    }
}
