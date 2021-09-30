package com.epam.tc.hw6.steps;

import com.epam.tc.hw6.pages.DifferentElementsPage;
import com.epam.tc.hw6.pages.HomePage;
import com.epam.tc.hw6.pages.IndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractStep {

    protected WebDriver webDriver;
    protected HomePage homePage;
    protected IndexPage indexPage;
    protected DifferentElementsPage differentElementsPage;

    protected AbstractStep(WebDriver webDriver) {
        this.webDriver = webDriver;
        homePage = PageFactory.initElements(webDriver, HomePage.class);
        indexPage = PageFactory.initElements(webDriver, IndexPage.class);
        differentElementsPage = PageFactory.initElements(webDriver, DifferentElementsPage.class);
    }

    @Step("Open test site by URL")
    public void openPage() {
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }
}
