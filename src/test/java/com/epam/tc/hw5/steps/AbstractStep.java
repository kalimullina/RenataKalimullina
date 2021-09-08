package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.HomePage;
import com.epam.tc.hw5.pages.UserPage;
import com.epam.tc.hw5.pages.UserTablePage;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected HomePage homePage;
    protected UserPage userPage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;


    public AbstractStep() {
        WebDriver webDriver = TestContext.getInstance().getTestObject("web_driver");

        homePage = new HomePage(webDriver);
        userPage = new UserPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        userTablePage = new UserTablePage(webDriver);
    }
}
