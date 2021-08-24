package com.epam.tc.hw2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ex2 {

    private WebDriver webDriver;
    private WebElement webElement;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void navigatingUserPageTest() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();


        //1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        SoftAssertions softAsserts = new SoftAssertions();

        //2. Assert Browser title
        assertThat(webDriver.getTitle())
            .as("The browser title was wrong")
            .isEqualTo("Home Page");


        //3. Perform login
        webDriver.findElement(By.cssSelector("a[href='#']")).click();
        webDriver.findElement(By.xpath("//*[@id='name']")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();


        //4. Assert User name in the left-top side of screen that user is loggined
        assertThat(webDriver.findElement(By.id("user-name")).getText())
            .as("Username was wrong")
            .isEqualTo("ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.className("menu-title")).click();
        webDriver.findElement(By.xpath("//*[@id='mCSB_1_container']/ul/li[3]/ul/li[8]/a")).click();


        //6. Select checkboxes
        List<WebElement> elements = webDriver.findElements(By.className("label-checkbox"));
        elements.get(0).click();
        elements.get(2).click();


        //7. Select radio
        elements = webDriver.findElements(By.className("label-radio"));
        elements.get(3).click();


        //8. Select in dropdown
        webDriver.findElement(By.className("colors")).click();
        elements = webDriver.findElements(By.tagName("option"));
        elements.get(3).click();


        //9. Assert that:...
        webElement = webDriver.findElement(By.cssSelector("ul[class='panel-body-list logs']"));
        String allString = webElement.getText();
        String[] separateStrings = allString.split("\n", 4);
        for (int i = 0; i < 4; i++) {
            separateStrings[i] = separateStrings[i].replaceAll("[0-9]",  "");
        }
        assertThat(separateStrings[0])
            .as("Color checkboxe is not an individual log row  and value is wrong")
            .isEqualTo(":: Colors: value changed to Yellow");
        assertThat(separateStrings[1])
            .as("Metal checkboxe is not an individual log row  and value is wrong")
            .isEqualTo(":: metal: value changed to Selen");
        assertThat(separateStrings[2])
            .as("Wind checkboxe is not an individual log row  and value is wrong")
            .isEqualTo(":: Wind: condition changed to true");
        assertThat(separateStrings[3])
            .as("Water checkboxe is not an individual log row  and value is wrong")
            .isEqualTo(":: Water: condition changed to true");
    }

    @AfterClass
    public void clear() {
        //10. Close Browser
        webDriver.close();
    }
}
