package com.epam.tc.hw5.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends BasePage  {

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

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

    public void selectWaterCheckbox() {
        checkBoxes.get(0).click();
    }

    public void selectWindCheckbox() {
        checkBoxes.get(2).click();
    }

    public void selectRadioSelen() {
        checkRadio.get(3).click();
    }

    public void selectYellowInDropdown() {
        dropdownWithColors.click();
        colorsInDropdown.get(3).click();
    }

    public String getLogRows() {
        return logRows.getText();
    }


}
