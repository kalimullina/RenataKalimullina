package com.epam.tc.hw4;

import static io.qameta.allure.Allure.step;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.pages.IndexPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class TestBase {

    protected static WebDriver webDriver;
    protected HomePage homePage;
    protected IndexPage indexPage;
    protected DifferentElementsPage differentElementsPage;

    FileInputStream file;
    protected Properties property;


    @BeforeClass(description = "Setting up test environment")
    public void setUp(ITestContext context) throws IOException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        context.setAttribute("driver", webDriver);

        homePage = PageFactory.initElements(webDriver, HomePage.class);
        indexPage = PageFactory.initElements(webDriver, IndexPage.class);
        differentElementsPage = PageFactory.initElements(webDriver, DifferentElementsPage.class);

        property = new Properties();
        file = new FileInputStream("src/test/resources/hw3/testHw3.properties");
        property.load(file);
    }

    @AfterClass(description = "Closing driver")
    public void tearDown() throws IOException {
        //12. Close Browser
        webDriver.close();

        file.close();
    }
}
