package hw3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "a[href='#']")
    private WebElement dropDownBeforeLogin;

    @FindBy(xpath = "//*[@id='name']")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    public void openPage() {
        TestBase.webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public String getTittle() {
        return TestBase.webDriver.getTitle();
    }

    public void login(String name, String password) {
        dropDownBeforeLogin.click();
        userName.sendKeys(name);
        userPassword.sendKeys(password);
        loginButton.click();
    }
}
