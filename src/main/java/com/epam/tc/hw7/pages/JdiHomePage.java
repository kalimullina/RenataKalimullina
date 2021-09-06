package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.forms.JdiLoginForm;
import org.hamcrest.Matchers;

public class JdiHomePage extends WebPage {

    private JdiLoginForm loginForm;

    @Css("#user-name")
    private Label userName;

    @Css(".profile-photo")
    private Button profilePhoto;

    public void login(User user) {
        profilePhoto.click();
        loginForm.login(user);
    }

    public void checkLoggedin(User user) {
        userName.shouldBe().text(Matchers.equalTo(user.getFullName()));
    }
}
