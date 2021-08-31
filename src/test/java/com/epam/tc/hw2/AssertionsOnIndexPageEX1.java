package com.epam.tc.hw2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class AssertionsOnIndexPageEX1 extends TestBase {

    @Test
    public void userIndexPageTest() {

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


        //4. Assert Username is loggined
        assertThat(webDriver.findElement(By.id("user-name")).getText())
            .as("Username was wrong")
            .isEqualTo("ROMAN IOVLEV");


        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertThat(webDriver.findElement(By.cssSelector("a[href='index.html']")).getText())
            .as("First item on the header section was wrong")
            .isEqualTo("HOME");
        assertThat(webDriver.findElement(By.cssSelector("a[href='contacts.html']")).getText())
            .as("Second item on the header section was wrong")
            .isEqualTo("CONTACT FORM");
        assertThat(webDriver.findElement(By.className("menu-title")).getText())
            .as("Third item on the header section was wrong")
            .isEqualTo("Service");
        assertThat(webDriver.findElement(By.cssSelector("a[href='metals-colors.html']")).getText())
            .as("Fourth item on the header section was wrong")
            .isEqualTo("METALS & COLORS");


        //6. Assert that there are 4 images on the Index Page and they are displayed
        webDriver.findElement(By.className("icon-practise")).isDisplayed();
        webDriver.findElement(By.className("icon-custom")).isDisplayed();
        webDriver.findElement(By.className("icon-multi")).isDisplayed();
        webDriver.findElement(By.className("icon-base")).isDisplayed();



        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement fisrtTextUnderIcon = webDriver.findElement(
            By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[1]/div/span"));
        assertThat(fisrtTextUnderIcon.getText())
            .as("Fisrt text on the Index Page under icon was wrong")
            .isEqualTo("To include good practices\nand ideas from successful\nEPAM project");
        WebElement secondTextUnderIcon = webDriver.findElement(
            By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[2]/div/span"));
        assertThat(secondTextUnderIcon.getText())
            .as("Second text on the Index Page under icon was wrong")
            .isEqualTo("To be flexible and\ncustomizable");
        WebElement thirdTextUnderIcon = webDriver.findElement(
            By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[3]/div/span"));
        assertThat(thirdTextUnderIcon.getText())
            .as("Third text on the Index Page under icon was wrong")
            .isEqualTo("To be multiplatform");
        WebElement fourthTextUnderIcon = webDriver.findElement(
            By.xpath("/html/body/div/div[2]/main/div[2]/div[2]/div[4]/div/span"));
        assertThat(fourthTextUnderIcon.getText())
            .as("Fourth text on the Index Page under icon was wrong")
            .isEqualTo("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");


        //8. Assert that there is the iframe with “Frame Button” exist
        WebElement frameWithButton = webDriver.findElement(By.id("frame"));
        frameWithButton.isDisplayed();


        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(frameWithButton);
        webDriver.findElement(By.id("frame-button")).isDisplayed();


        //10. Switch to original window back
        webDriver.switchTo().defaultContent();


        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> elements = webDriver.findElements(By.tagName("li"));
        assertThat(elements.get(0).getText())
            .as("First item in the Left Section was wrong")
            .isEqualTo("HOME");
        assertThat(elements.get(1).getText())
            .as("Second item in the Left Section was wrong")
            .isEqualTo("CONTACT FORM");
        assertThat(elements.get(2).getText())
            .as("Third item in the Left Section was wrong")
            .isEqualTo("SERVICE");
        assertThat(webDriver.findElement(By.cssSelector("a[href='metals-colors.html']")).getText())
            .as("Fourth item in the Left Section was wrong")
            .isEqualTo("METALS & COLORS");
    }
}
