package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class JdiMetalsAndColorsPage extends WebPage {

    @Css("#odds-selector")
    public RadioButtons summaryFirstLine;

    @Css("#even-selector")
    public RadioButtons summarySecondLine;

    @Css("p[class=checkbox]")
    public Checklist elementsSettings;

    @JDropdown(root = "div[ui=dropdown]",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public DataListOptions  colorsSettings;

    @JDropdown(root = "div[ui=combobox]",
               list = "li",
               value = ".filter-option",
               expand = ".caret")
    private DataListOptions  metals;

    @JDropdown(root = "div[ui=droplist]",
               list = "li",
               value = ".filter-option",
               expand = ".caret")
    private DataListOptions vegetablesSettings;

    @Css("#submit-button")
    public Button submitButton;

    @Css("li[class=summ-res]")
    public Text summaryResult;

    @Css("li[class=elem-res]")
    public Text elementsResult;

    @Css("li[class=col-res]")
    public Text colorResult;

    @Css("li[class=met-res]")
    public Text metalResult;

    @Css("li[class=sal-res]")
    public Text vegetablesResult;
}
