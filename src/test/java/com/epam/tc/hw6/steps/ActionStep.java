package com.epam.tc.hw6.steps;

import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    public void loginAsUser(String name, String password) {
        homePage.login(name, password);
    }

    public void switchToTheIframe() {
        webDriver.switchTo().frame(indexPage.returnIframe());
    }

    public void switchToTheOriginalWindow() {
        webDriver.switchTo().defaultContent();
    }

    public void openDifferentElementsPage() {
        indexPage.clickOnServiceHeaderMenu()
                 .clickOnDifferentElementsPageHeaderMenu();
    }

    public void selectCheckboxesRadioAndDropdown() {
        differentElementsPage.selectWaterCheckbox()
                             .selectWindCheckbox()
                             .selectRadioSelen()
                             .selectYellowInDropdown();
    }
}
