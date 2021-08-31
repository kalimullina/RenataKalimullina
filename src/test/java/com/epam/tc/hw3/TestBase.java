package com.epam.tc.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class TestBase {

    protected static WebDriver webDriver;
    protected HomePage homePage;
    protected IndexPage indexPage;
    protected DifferentElementsPage differentElementsPage;

    FileInputStream file;
    protected Properties property;


    @BeforeClass
    public void setupClass() throws IOException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        homePage = PageFactory.initElements(webDriver, HomePage.class);
        indexPage = PageFactory.initElements(webDriver, IndexPage.class);
        differentElementsPage = PageFactory.initElements(webDriver, DifferentElementsPage.class);

        property = new Properties();
        file = new FileInputStream("src/test/resources/testHw3.properties");
        property.load(file);
    }

    @AfterClass
    public void clear() throws IOException {
        //12. Close Browser
        webDriver.close();

        file.close();
    }
}
