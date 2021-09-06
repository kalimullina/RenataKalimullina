package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.tc.hw7.entities.MenuOptions;

public class JdiUserPage extends WebPage {

    @FindBy(css = "header ul[class='uui-navigation nav navbar-nav m-l8']")
    public Menu headerMenu;

    public void openPageFromHeaderMenu(MenuOptions option) {
        headerMenu.select(option.getMenuOption());
    }
}
