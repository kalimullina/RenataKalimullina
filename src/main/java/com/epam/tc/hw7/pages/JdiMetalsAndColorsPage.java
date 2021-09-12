package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.Data;
import java.util.List;
import org.hamcrest.Matchers;

public class JdiMetalsAndColorsPage extends WebPage {

    @UI("[name=custom_radio_odd]")
    public RadioButtons summaryFirstLine;

    @UI("[name=custom_radio_even]")
    public RadioButtons summarySecondLine;

    @UI("input[type=checkbox]")
    public Checklist elementsSettings;

    @JDropdown(root = ".colors",
               value = ".dropdown-value",
               list = "li",
               expand = ".caret")
    public Dropdown colorsSettings;

    @JDropdown(root = ".metals",
               value = ".dropdown-value",
               list = "li",
               expand = ".caret")
    private Dropdown metals;

    @JDropdown(root = "#salad-dropdown",
               value = ".dropdown-value",
               list = "li",
               expand = ".caret")
    private Dropdown vegetablesSettings;

    @UI("#submit-button")
    public Button submitButton;

    @UI(".summ-res")
    public Text summaryResult;

    @UI(".elem-res")
    public Text elementsResult;

    @UI(".col-res")
    public Text colorResult;

    @UI(".met-res")
    public Text metalResult;

    @UI(".sal-res")
    public Text vegetablesResult;



    public void chooseSummary(List<Integer> summary) {
        summaryFirstLine.select(summary.get(0).toString());
        summarySecondLine.select(summary.get(1).toString());
    }

    public void chooseElements(List<String> elements) {
        for (String element : elements) {
            elementsSettings.select(element);
        }
    }

    public void chooseColor(String colorsName) {
        colorsSettings.setValue(colorsName);
    }

    public void chooseMetal(String metalsName) {
        metals.select(metalsName);
    }

    public void chooseVegetables(List<String> vegetables) {
        vegetablesSettings.select("Vegetables");
        for (String vegetable : vegetables) {
            vegetablesSettings.select(vegetable);
        }
    }

    public void submitFormMetalsColors() {
        submitButton.click();
    }

    public void checkResultLog(Data dataFromJson) {
        Integer summaryActualResult = 0;
        for (Integer summary : dataFromJson.getSummary()) {
            summaryActualResult += summary;
        }
        summaryResult.shouldBe().text(Matchers.equalTo("Summary: " + summaryActualResult.toString()));

        List<String> elements = dataFromJson.getElements();
        String elementsExpectedResult = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            elementsExpectedResult = elementsExpectedResult + ", " + elements.get(i);
        }
        elementsResult.shouldBe().text(Matchers.equalTo("Elements: " + elementsExpectedResult));

        colorResult.shouldBe().text(Matchers.equalTo("Color: " + dataFromJson.getColor()));
        metalResult.shouldBe().text(Matchers.equalTo("Metal: " + dataFromJson.getMetals()));


        List<String> vegetables = dataFromJson.getVegetables();
        String vegetablesExpectedResult = vegetables.get(0);
        for (int i = 1; i < vegetables.size(); i++) {
            vegetablesExpectedResult = vegetablesExpectedResult + ", " + vegetables.get(i);
        }
        vegetablesResult.shouldBe().text(Matchers.equalTo("Vegetables: " + vegetablesExpectedResult));
    }
}
