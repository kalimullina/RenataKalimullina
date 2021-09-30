package com.epam.tc.hw6.tests;

import com.epam.tc.hw6.listeners.ScreenshotListener;
import com.epam.tc.hw6.tags.FeaturesTags;
import com.epam.tc.hw6.tags.StoriesTags;
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
        actionStep.openPage();

        //2. Assert Browser title
        assertionStep.assertBrowserTitle();

        //3. Perform login
        actionStep.loginAsUser(property.getProperty("userName"), property.getProperty("userPassword"));

        //4. Assert Username is loggined
        assertionStep.assertUsernameIsLoggined();

        //5. Open through the header menu Service -> Different Elements Page
        actionStep.openDifferentElementsPage();

        //6. Select checkboxes  &  7. Select radio  &  8. Select in dropdown
        actionStep.selectCheckboxesRadioAndDropdown();

        //9. Assert log rows
        assertionStep.assertLogRows();
    }
}
