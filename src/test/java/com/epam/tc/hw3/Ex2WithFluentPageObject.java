package com.epam.tc.hw3;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import hw3.TestBase;
import org.testng.annotations.Test;

public class Ex2WithFluentPageObject extends TestBase {

    @Test
    public void navigatingUserPageTest() {

        //1. Open test site by URL
        homePage.openPage();

        //2. Assert Browser title
        assertThat(homePage.getTittle())
            .as("The browser title was wrong")
            .isEqualTo("Home Page");

        //3. Perform login
        homePage.login(property.getProperty("userName"), property.getProperty("userPassword"));

        //4. Assert Username is loggined
        assertThat(indexPage.getLoggedUser())
            .as("Username was wrong")
            .isEqualTo("ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        indexPage.clickOnServiceHeaderMenu()
                 .clickOnDifferentElementsPageHeaderMenu();

        //6. Select checkboxes  &  7. Select radio  &  8. Select in dropdown
        differentElementsPage.selectWaterCheckbox()
                             .selectWindCheckbox()
                             .selectRadioSelen()
                             .selectYellowInDropdown();

        //9. Assert that:...
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
}
