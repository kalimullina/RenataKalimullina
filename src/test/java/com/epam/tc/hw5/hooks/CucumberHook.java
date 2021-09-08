package com.epam.tc.hw5.hooks;

import com.epam.tc.hw5.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHook {

    private WebDriver webDriver;

    @Before
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        TestContext.getInstance().addTestObject("web_driver", webDriver);
    }

    @After
    public void tearDownDriver() {
        webDriver.close();
        TestContext.getInstance().clean();
    }
}
