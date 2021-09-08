package com.epam.tc.hw5.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends BasePage {

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "tbody select")
    private List<WebElement> dropdowns;

    @FindBy(css = "tbody a")
    private List<WebElement> names;

    @FindBy(css = "tbody img")
    private List<WebElement> images;

    @FindBy(css = "div[class = 'user-descr'] input[type=checkbox]")
    private List<WebElement> checkbexes;

    @FindBy(css = "div[class = 'user-descr'] span")
    private List<WebElement> texts;

    @FindBy(css = "tbody select option")
    private List<WebElement> dropdownValues;

    @FindBy(css = ".info-panel-section")
    private WebElement  logRow;


    /*Ex1*/
    public String getTitle() {
        return webDriver.getTitle();
    }

    public boolean checkDropdownsAreDisplayed() {
        int i;
        for (i = 0; i < 6; i++) {
            dropdowns.get(i).isDisplayed();
        }
        if (i == 6) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUserNamesAreDisplayed() {
        int i;
        for (i = 0; i < 6; i++) {
            names.get(i).isDisplayed();
        }
        if (i == 6) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkDescriptionImagesAreDisplayed() {
        int i;
        for (i = 0; i < 6; i++) {
            images.get(i).isDisplayed();
        }
        if (i == 6) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCheckboxesAreDisplayed() {
        int i;
        for (i = 0; i < 6; i++) {
            checkbexes.get(i).isDisplayed();
        }
        if (i == 6) {
            return true;
        } else {
            return false;
        }
    }



    public String getName(Integer number) {
        return names.get(number).getText();
    }

    public String getDescription(Integer number) {
        return texts.get(number).getText();
    }


    public String getDropdownValues() {
        return dropdownValues.get(0).getText() + "\n"
            + dropdownValues.get(1).getText() + "\n"
            + dropdownValues.get(2).getText();
    }

    /*Ex3*/
    public void selectSergeyIvan() {
        checkbexes.get(1).click();
    }

    public String getLogRowText() {
        return logRow.getText();
    }
}
