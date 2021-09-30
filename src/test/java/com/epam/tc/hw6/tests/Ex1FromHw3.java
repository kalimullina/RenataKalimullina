package com.epam.tc.hw6.tests;

import com.epam.tc.hw6.listeners.ScreenshotListener;
import com.epam.tc.hw6.tags.FeaturesTags;
import com.epam.tc.hw6.tags.StoriesTags;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
@Feature(FeaturesTags.INDEX_PAGE_FUNCTIONALITY)
@Story(StoriesTags.USER_INDEX_PAGE_TESTING)
public class Ex1FromHw3 extends TestBase {

    @Test
    public void userIndexPageTest() {

        //1. Open test site by URL
        actionStep.openPage();

        //2. Assert Browser title
        assertionStep.assertBrowserTitle();

        //3. Perform login
        actionStep.loginAsUser(property.getProperty("userName"), property.getProperty("userPassword"));

        //4. Assert Username is loggined
        assertionStep.assertUsernameIsLoggined();

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.assertFourItemsAndTextsIndexPage();

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.assertFourImagesIndexPage();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.assertFourTextsUnderIconsIndexPage();

        //8. Assert that there is the iframe with “Frame Button” exist
        assertionStep.assertIframeExist();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchToTheIframe();
        assertionStep.checkIframeButton();

        //10. Switch to original window back
        actionStep.switchToTheOriginalWindow();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.assertFiveItemsInLeftSectionAndTexts();
    }
}
