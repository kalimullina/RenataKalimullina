package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class TestBase {

    protected static WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        //12. Close Browser
        webDriver.close();
    }

}
