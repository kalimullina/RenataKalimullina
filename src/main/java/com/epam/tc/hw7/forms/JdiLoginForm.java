package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.entities.User;

public class JdiLoginForm extends Form<User> {

    @FindBy(css = "#name")
    TextField login;

    @FindBy(css = "#password")
    TextField password;

    @FindBy(css = "#login-button")
    Button submit;

    @Override
    public void login(User user) {
        login.input(user.getLogin());
        password.input(user.getPassword());

        submit.click();
    }
}
