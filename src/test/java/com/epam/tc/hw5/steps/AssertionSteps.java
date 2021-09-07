package com.epam.tc.hw5.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.entities.UserTableValue;
import io.cucumber.java.en.Then;
import java.util.List;

public class AssertionSteps extends AbstractStep {

    /*Ex1*/
    @Then("Check for each selected element individual log row")
    public void checkForEachSelectedElement() {
        String allString = differentElementsPage.getLogRows();
        String[] separateStrings = allString.split("\n", 4);
        for (int i = 0; i < 4; i++) {
            separateStrings[i] = separateStrings[i].replaceAll("[0-9]",  "");
        }
        assertThat(separateStrings[0])
            .as("Color checkboxe is not an individual log row  and value is wrong")
            .isEqualTo(":: Colors: value changed to Yellow");
        assertThat(separateStrings[1])
            .as("Metal checkboxe is not an individual log row  and value is wrong")
            .isEqualTo(":: metal: value changed to Selen");
        assertThat(separateStrings[2])
            .as("Wind checkboxe is not an individual log row  and value is wrong")
            .isEqualTo(":: Wind: condition changed to true");
        assertThat(separateStrings[3])
            .as("Water checkboxe is not an individual log row  and value is wrong")
            .isEqualTo(":: Water: condition changed to true");
    }

    /*Ex2*/
    @Then("\"User Table\" page should be opened")
    public void checkUserTableTittle() {
        assertThat(userTablePage.getTitle())
            .as("Opening User Table Page was wrong")
            .isEqualTo("User Table");
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkNumberTypeDropdowns() {
        assertThat(userTablePage.checkDropdownsAreDisplayed())
            .as("6 NumberType Dropdowns are not displayed on Users Table on User Table Page")
            .isTrue();
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void checkUserNames() {
        assertThat(userTablePage.checkUserNamesAreDisplayed())
            .as("6 Usernames are not displayed on Users Table on User Table Page")
            .isTrue();

    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void checkDescriptionImages() {
        assertThat(userTablePage.checkDescriptionImagesAreDisplayed())
            .as("6 Description texts under images are not displayed on Users Table on User Table Page")
            .isTrue();
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkCheckboxes() {
        assertThat(userTablePage.checkCheckboxesAreDisplayed())
            .as("6 checkboxes are not displayed on Users Table on User Table Page")
            .isTrue();
    }

    @Then("User table should contain following values:")
    public void userTableContains(List<UserTableValue> values) {

        for (int i = 0; i < 3; i++) {
            assertThat(values.get(i).getUser())
                .as("Username was wrong")
                .isEqualTo(userTablePage.getName(i));
            assertThat(values.get(i).getDescription())
                .as("Description was wrong")
                .isEqualTo(userTablePage.getDescription(i));
        }

        for (int i = 3; i < 6; i++) {
            assertThat(values.get(i).getUser())
                .as("Username was wrong")
                .isEqualTo(userTablePage.getName(i));
            assertThat(values.get(i).getDescription())
                .as("Description was wrong")
                .isEqualTo(userTablePage.getDescription(i).replaceAll("\n", " "));
        }
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistContainsValues(List<String> dropdownValues) {
        assertThat(userTablePage.getDropdownValues())
            .as("Droplist doesn't contain values in column Type for user Roman")
                .isEqualTo(dropdownValues.get(1) + "\n" + dropdownValues.get(2) + "\n" + dropdownValues.get(3));
    }


    /*Ex3*/
    @Then("1 log row has \"Vip: condition changed to true\" text in log section")
    public void checkLogRowWithVipCheckbox() {

        String logRowForVipCheckbox = TestContext.getInstance().getTestObject("time_forLogRow_UserTable")
            + " Vip: condition changed to true";
        assertThat(userTablePage.getLogRowText())
            .as("Checking log row about Vip was wrong")
            .isEqualTo(logRowForVipCheckbox);
    }
}
