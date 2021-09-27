package com.epam.tc.hw6.tests;

import com.epam.tc.hw6.driver.WebDriverSingleton;
import com.epam.tc.hw6.steps.ActionStep;
import com.epam.tc.hw6.steps.AssertionStep;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class TestBase {

    ActionStep actionStep;
    AssertionStep assertionStep;

    FileInputStream file;
    protected Properties property;


    @BeforeClass(description = "Setting up test environment")
    public void setUp(ITestContext context) throws IOException {
        WebDriver webDriver = WebDriverSingleton.getDriver();

        webDriver.manage().window().maximize();
        context.setAttribute("driver", webDriver);
        actionStep = new ActionStep(webDriver);
        assertionStep = new AssertionStep(webDriver);

        property = new Properties();
        file = new FileInputStream("src/test/resources/hw3/testHw3.properties");
        property.load(file);
    }

    @AfterClass(description = "Closing driver")
    public void tearDown() throws IOException {
        //12. Close Browser
        WebDriverSingleton.closeDriver();

        file.close();
    }
}
