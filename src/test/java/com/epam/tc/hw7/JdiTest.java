package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;

import com.epam.tc.hw7.data.DataProviderJdi;
import com.epam.tc.hw7.entities.DataFromJson;
import com.epam.tc.hw7.entities.MenuOptions;
import com.epam.tc.hw7.entities.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JdiTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterClass() {
        killAllSeleniumDrivers();
    }

    @BeforeTest
    public void beforeClass() {
        JdiSite.open();

        //Login on JDI site as User
        JdiSite.login(User.ROMAN);
    }

    @Test(dataProviderClass = DataProviderJdi.class, dataProvider = "jsonData")
    public void loginTest(DataFromJson dataFromJson) {

        JdiSite.homePage.checkLoggedin(User.ROMAN);

        //Open Metals & Colors page by Header menu
        JdiSite.userPage.openPageFromHeaderMenu(MenuOptions.METALS_AND_COLORS);

        //Fill form Metals & Colors by data from json
        JdiSite.metalsAndColorsPage.chooseSummary(dataFromJson.getSummary());
        JdiSite.metalsAndColorsPage.chooseElements(dataFromJson.getElements());
        JdiSite.metalsAndColorsPage.chooseColor(dataFromJson.getColor());
        JdiSite.metalsAndColorsPage.chooseMetal(dataFromJson.getMetals());
        JdiSite.metalsAndColorsPage.chooseVegetables(dataFromJson.getVegetables());

        //Submit form Metals & Colors
        JdiSite.metalsAndColorsPage.submitFormMetalsColors();

        //Result sections should contains data from json
        JdiSite.metalsAndColorsPage.checkResultLog(dataFromJson);
    }
}
