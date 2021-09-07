package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.context.TestContext;
import io.cucumber.java.en.When;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActionSteps extends AbstractStep {

    /*Ex1*/
    @When("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPageThroughHeaderMenu() {
        userPage.clickOnServiceHeaderMenu();
        userPage.clickOnDifferentElementsPageHeaderMenu();
    }

    @When("I select Water and Wind checkboxes")
    public void selectWaterAndWindCheckboxes() {
        differentElementsPage.selectWaterCheckbox();
        differentElementsPage.selectWindCheckbox();
    }

    @When("I select Selen radio")
    public void selectSelenRadio() {
        differentElementsPage.selectRadioSelen();
    }

    @When("I select Yellow in dropdown")
    public void selectYellowInDropdown() {
        differentElementsPage.selectYellowInDropdown();
    }


    /*Ex2*/
    @When("I click on \"Service\" button in Header")
    public void clickOnServiceButtonInHeader() {
        userPage.clickOnServiceHeaderMenu();
    }

    @When("I click on \"User Table\" button in Service dropdown")
    public void clickOnUserTableButtonInHeader() {
        userPage.clickOnUserTablePageHeaderMenu();
    }

    /*Ex3*/
    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectCheckboxSergeyIvan() {
        userTablePage.selectSergeyIvan();
        String timeForLogRowUserTable = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        TestContext.getInstance().addTestObject("time_forLogRow_UserTable", timeForLogRowUserTable);
    }
}
