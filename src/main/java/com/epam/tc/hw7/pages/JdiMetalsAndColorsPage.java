package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.Elements;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JdiMetalsAndColorsPage extends WebPage {

    //@Css("#odds-selector")
    @Css("[id='odds-selector']")
    public RadioButtons summaryFirstLine;

    @Css("#even-selector")
    public RadioButtons summarySecondLine;

    //@Css("p[class=checkbox]")
    @Css("section[id='elements-checklist']")
    public Checklist elementsSettings;

    @Css("button[title='Colors']")
    public DataListOptions  colorsSettings;

    @Css("button[title='Metals']")
    private DataListOptions  metals;

    /*@JDropdown(root = "div[ui=droplist]",
               list = "li",
               value = ".filter-option",
               expand = ".caret")
    private DataListOptions vegetablesSettings;*/

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



    public void chooseSummary(List<Integer> summary) {
        summaryFirstLine.select(summary.get(0).toString());
        summarySecondLine.select(summary.get(1).toString());
    }


    public void chooseElements(List<String> elements) {
        for (String element : elements) {
            elementsSettings.setValue(element);
            /*if (Objects.equals(element, Elements.WATER.getName())) {
                elementsSettings.select(Elements.WATER.getNumber());
            } else if (Objects.equals(element, Elements.EARTH.getName())) {
                elementsSettings.select(Elements.EARTH.getNumber());
            } else if (Objects.equals(element, Elements.WIND.getName())) {
                elementsSettings.select(Elements.WIND.getNumber());
            } else if (Objects.equals(element, Elements.FIRE.getName())) {
                elementsSettings.select(Elements.FIRE.getNumber());
            }*/
        }
    }


    public void chooseColor(String colorsName) {
        colorsSettings.select(colorsName);
    }
}
