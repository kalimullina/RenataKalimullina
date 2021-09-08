package com.epam.tc.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {

    public UserPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(className = "dropdown-toggle")
    private WebElement serviceOnHeaderMenu;

    @FindBy(xpath = "/html/body/header/div/nav/ul[1]/li[3]/ul/li[8]/a")
    private WebElement differentElementsPageHeaderMenu;

    @FindBy(xpath = "/html/body/header/div/nav/ul[1]/li[3]/ul/li[6]/a")
    private WebElement userTablePageHeaderMenu;

    public void clickOnServiceHeaderMenu() {
        serviceOnHeaderMenu.click();
    }

    public void clickOnDifferentElementsPageHeaderMenu() {
        differentElementsPageHeaderMenu.click();
    }

    public void clickOnUserTablePageHeaderMenu() {
        userTablePageHeaderMenu.click();
    }
}
