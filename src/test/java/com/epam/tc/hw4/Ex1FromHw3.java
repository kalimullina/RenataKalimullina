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
@Feature(FeaturesTags.INDEX_PAGE_FUNCTIONALITY)
@Story(StoriesTags.USER_INDEX_PAGE_TESTING)
public class Ex1FromHw3 extends TestBase {

    @Test
    public void userIndexPageTest() {

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

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertThat(indexPage.getHomeItemOnHeaderSection())
            .as("First item on the header section was wrong")
            .isEqualTo("HOME");
        assertThat(indexPage.getContactFormItemOnHeaderSection())
            .as("Second item on the header section was wrong")
            .isEqualTo("CONTACT FORM");
        assertThat(indexPage.getServiceItemOnHeaderSection())
            .as("Third item on the header section was wrong")
            .isEqualTo("Service");
        assertThat(indexPage.getMetalsColorsItemOnHeaderSection())
            .as("Fourth item on the header section was wrong")
            .isEqualTo("METALS & COLORS");


        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertThat(indexPage.checkFourImages())
            .as("Displaying the images on the Index Page was wrong")
            .isEqualTo(true);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertThat(indexPage.getTextUnderIcons(1))
            .as("Fisrt text on the Index Page under icon was wrong")
            .isEqualTo("To include good practices\nand ideas from successful\nEPAM project");
        assertThat(indexPage.getTextUnderIcons(2))
            .as("Second text on the Index Page under icon was wrong")
            .isEqualTo("To be flexible and\ncustomizable");
        assertThat(indexPage.getTextUnderIcons(3))
            .as("Third text on the Index Page under icon was wrong")
            .isEqualTo("To be multiplatform");
        assertThat(indexPage.getTextUnderIcons(4))
            .as("Fourth text on the Index Page under icon was wrong")
            .isEqualTo("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //8. Assert that there is the iframe with “Frame Button” exist
        assertThat(indexPage.iframeIsExisted())
            .as("Displaying the iframe “Frame Button” was wrong")
            .isEqualTo(true);

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(indexPage.returnIframe());
        assertThat(indexPage.checkIframeButton())
            .as("Displaying “Frame Button” in the iframe was wrong")
            .isEqualTo(true);

        //10. Switch to original window back
        webDriver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertThat(indexPage.fourItemsLeftSection(0))
            .as("First item in the Left Section was wrong")
            .isEqualTo("HOME");
        assertThat(indexPage.fourItemsLeftSection(1))
            .as("Second item in the Left Section was wrong")
            .isEqualTo("CONTACT FORM");
        assertThat(indexPage.fourItemsLeftSection(2))
            .as("Third item in the Left Section was wrong")
            .isEqualTo("SERVICE");
        assertThat(indexPage.getMetalsLeftSection())
            .as("Fourth item in the Left Section was wrong")
            .isEqualTo("METALS & COLORS");
    }
}
