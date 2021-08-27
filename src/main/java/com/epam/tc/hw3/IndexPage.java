package com.epam.tc.hw3;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {

    @FindBy(id = "user-name")
    private WebElement logginedUser;

    @FindBy(css = "a[href='index.html']")
    private WebElement homeItemOnHeaderSection;

    @FindBy(css = "a[href='contacts.html']")
    private WebElement contactFormItemOnHeaderSection;

    @FindBy(className = "menu-title")
    private WebElement serviceItemOnHeaderSection;

    @FindBy(css = "a[href='metals-colors.html']")
    private WebElement metalsColorsItemOnHeaderSection;

    @FindBy(className = "icon-practise")
    private WebElement firstImage;

    @FindBy(className = "icon-custom")
    private WebElement secondImage;

    @FindBy(className = "icon-multi")
    private WebElement thirdImage;

    @FindBy(className = "icon-base")
    private WebElement fourthImage;


    @FindBy(xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div[1]/div/span")
    private WebElement firstTextUnderIcons;

    @FindBy(xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div[2]/div/span")
    private WebElement secondTextUnderIcons;

    @FindBy(xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div[3]/div/span")
    private WebElement thirdTextUnderIcons;

    @FindBy(xpath = "/html/body/div/div[2]/main/div[2]/div[2]/div[4]/div/span")
    private WebElement fourthTextUnderIcons;

    @FindBy(id = "frame")
    private WebElement iframeWithFrameButton;

    @FindBy(id = "frame-button")
    private WebElement iframeButton;

    @FindBy(tagName = "li")
    private List<WebElement> elementsLeftSection;

    @FindBy(css = "a[href='metals-colors.html']")
    private WebElement metalsColorsLeftSection;

    /*Ex2*/
    @FindBy(className = "menu-title")
    private WebElement serviceOnHeaderMenu;

    @FindBy(xpath = "//*[@id='mCSB_1_container']/ul/li[3]/ul/li[8]/a")
    private WebElement differentElementsPageHeaderMenu;



    public String getLoggedUser() {
        return logginedUser.getText();
    }

    /*Ex1*/
    public String getHomeItemOnHeaderSection() {
        return homeItemOnHeaderSection.getText();
    }

    public String getContactFormItemOnHeaderSection() {
        return contactFormItemOnHeaderSection.getText();
    }

    public String getServiceItemOnHeaderSection() {
        return serviceItemOnHeaderSection.getText();
    }

    public String getMetalsColorsItemOnHeaderSection() {
        return metalsColorsItemOnHeaderSection.getText();
    }

    public void checkFourImages() {
        firstImage.isDisplayed();
        secondImage.isDisplayed();
        thirdImage.isDisplayed();
        fourthImage.isDisplayed();
    }

    public String getTextUnderIcons(int number) {
        if (number == 1) {
            return firstTextUnderIcons.getText();
        } else if (number == 2) {
            return secondTextUnderIcons.getText();
        } else if (number == 3) {
            return thirdTextUnderIcons.getText();
        } else if (number == 4) {
            return fourthTextUnderIcons.getText();
        } else {
            return null;
        }
    }

    public void iframeIsExisted() {
        iframeWithFrameButton.isDisplayed();
    }

    public WebElement returnIframe() {
        return iframeWithFrameButton;
    }

    public void checkIframeButton() {
        iframeButton.isDisplayed();
    }

    public String fourItemsLeftSection(int number) {
        return elementsLeftSection.get(number).getText();
    }

    public String getMetalsLeftSection() {
        return metalsColorsLeftSection.getText();
    }




    /*Ex2*/
    public IndexPage clickOnServiceHeaderMenu() {
        serviceOnHeaderMenu.click();
        return this;
    }

    public void clickOnDifferentElementsPageHeaderMenu() {
        differentElementsPageHeaderMenu.click();
    }

}
