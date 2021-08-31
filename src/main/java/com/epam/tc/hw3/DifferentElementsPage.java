package com.epam.tc.hw3;

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



    public DifferentElementsPage selectWaterCheckbox() {
        checkBoxes.get(0).click();
        return this;
    }

    public DifferentElementsPage selectWindCheckbox() {
        checkBoxes.get(2).click();
        return this;
    }

    public DifferentElementsPage selectRadioSelen() {
        checkRadio.get(3).click();
        return this;
    }

    public DifferentElementsPage selectYellowInDropdown() {
        dropdownWithColors.click();
        colorsInDropdown.get(3).click();
        return this;
    }

    public String getLogRows() {
        return logRows.getText();
    }
}
