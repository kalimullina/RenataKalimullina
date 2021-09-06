package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;

import com.epam.tc.hw7.entities.DataFromJson;
import com.epam.tc.hw7.entities.MenuOptions;
import com.epam.tc.hw7.entities.User;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JdiTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws FileNotFoundException {
        initSite(JdiSite.class);

        Gson g = new Gson();
        DataFromJson dataFromJson = g.fromJson(
            new FileReader("src/test/resources/hw7/JDI_ex8_metalsColorsDataSet.json"),
            DataFromJson.class);

       
    }

    @AfterSuite(alwaysRun = true)
    public void afterClass() {
        killAllSeleniumDrivers();
    }

    @Test
    public void loginTest() {
        JdiSite.open();

        //Login on JDI site as User
        JdiSite.login(User.ROMAN);
        JdiSite.homePage.checkLoggedin(User.ROMAN);

        //Open Metals & Colors page by Header menu
        JdiSite.userPage.openPageFromHeaderMenu(MenuOptions.METALS_AND_COLORS);
    }
}
