package com.epam.tc.hw6.pages;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxes;

    @FindBy(className = "label-radio")
    private List<WebElement> checkRadio;

    @FindBy(className = "colors")
    private WebElement dropdownWithColors;

    @FindBy(tagName = "option")
    private List<WebElement> colorsInDropdown;

    @FindBy(css = "ul[class='panel-body-list logs']")
    private WebElement logRows;


    @Step("Select Water checkbox")
    public DifferentElementsPage selectWaterCheckbox() {
        checkBoxes.get(0).click();
        return this;
    }

    @Step("Select Wind checkbox")
    public DifferentElementsPage selectWindCheckbox() {
        checkBoxes.get(2).click();
        return this;
    }

    @Step("Select Selen radio")
    public DifferentElementsPage selectRadioSelen() {
        checkRadio.get(3).click();
        return this;
    }

    @Step("Select Yellow in dropdown")
    public DifferentElementsPage selectYellowInDropdown() {
        dropdownWithColors.click();
        colorsInDropdown.get(3).click();
        return this;
    }

    @Step("Get log rows")
    public String getLogRows() {
        return logRows.getText();
    }
}
