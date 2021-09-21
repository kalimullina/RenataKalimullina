package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.hw7.entities.MenuOptions;

public class JdiUserPage extends WebPage {

    @UI("[class^='uui-navigation nav ']")
    private Menu headerMenu;

    @UI(".profile-photo")
    private Button profilePhoto;

    public void openPageFromHeaderMenu(MenuOptions option) {
        headerMenu.select(option.getMenuOption());
    }
}
