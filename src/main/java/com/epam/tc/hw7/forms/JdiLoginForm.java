package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.entities.User;

public class JdiLoginForm extends Form<User> {

    @UI("#name")
    TextField login;

    @UI("#password")
    TextField password;

    @UI("#login-button")
    Button submit;

    @Override
    public void login(User user) {
        login.input(user.getLogin());
        password.input(user.getPassword());

        submit.click();
    }
}
