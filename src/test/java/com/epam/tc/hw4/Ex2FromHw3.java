package com.epam.tc.hw4;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw4.listeners.ScreenshotListener;
import com.epam.tc.hw4.tags.FeaturesTags;
import com.epam.tc.hw4.tags.StoriesTags;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class Ex2FromHw3 extends TestBase {

    @Test
    @Feature(FeaturesTags.DIFFERENT_ELEMENTS_PAGE_FUNCTIONALITY)
    @Story(StoriesTags.DIFFERENT_ELEMENTS_PAGE_TESTING)
    public void differentElementsPageTest() {

        //1. Open test site by URL
        homePage.openPage(TestBase.webDriver);

        //2. Assert Browser title
        assertThat(homePage.getTittle(TestBase.webDriver))
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

        //9. Assert log rows
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
