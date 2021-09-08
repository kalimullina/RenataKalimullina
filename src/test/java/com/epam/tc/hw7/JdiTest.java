package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;

import com.epam.tc.hw1.data.DataProviders;
import com.epam.tc.hw7.data.DataProviderJdi;
import com.epam.tc.hw7.entities.Data;
import com.epam.tc.hw7.entities.MenuOptions;
import com.epam.tc.hw7.entities.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JdiTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterClass() {

        //killAllSeleniumDrivers();
    }

    @Test(dataProviderClass = DataProviderJdi.class, dataProvider = "jsonData")
    public void loginTest(Data dataFromJson) {
        JdiSite.open();

        //Login on JDI site as User
        JdiSite.login(User.ROMAN);
        JdiSite.homePage.checkLoggedin(User.ROMAN);

        //Open Metals & Colors page by Header menu
        JdiSite.userPage.openPageFromHeaderMenu(MenuOptions.METALS_AND_COLORS);

        //Fill form Metals & Colors by data from json
        JdiSite.metalsAndColorsPage.chooseSummary(dataFromJson.getSummary());
        JdiSite.metalsAndColorsPage.chooseElements(dataFromJson.getElements());
        JdiSite.metalsAndColorsPage.chooseColor(dataFromJson.getColor());
    }
}
