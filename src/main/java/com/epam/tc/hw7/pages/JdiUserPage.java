package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.hw7.entities.MenuOptions;

public class JdiUserPage extends WebPage {

    @UI("header ul[class='uui-navigation nav navbar-nav m-l8']")
    public Menu headerMenu;

    @UI(".profile-photo")
    private Button profilePhoto;

    @UI(".logout")
    private Button logoutButton;

    public void openPageFromHeaderMenu(MenuOptions option) {
        headerMenu.select(option.getMenuOption());
    }

    public void logoutFromUserAccount() {
        profilePhoto.click();
        logoutButton.click();
    }
}
