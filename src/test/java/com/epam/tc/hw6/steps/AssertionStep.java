package com.epam.tc.hw6.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.openqa.selenium.WebDriver;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    public void assertBrowserTitle() {
        assertThat(homePage.getTittle(webDriver))
            .as("The browser title was wrong")
            .isEqualTo("Home Page");
    }

    public void assertUsernameIsLoggined() {
        assertThat(indexPage.getLoggedUser())
            .as("Username was wrong")
            .isEqualTo("ROMAN IOVLEV");
    }

    public void assertFourItemsAndTextsIndexPage() {
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
    }

    public void assertFourImagesIndexPage() {
        assertThat(indexPage.checkFourImages())
            .as("Displaying the images on the Index Page was wrong")
            .isEqualTo(true);
    }

    public void assertFourTextsUnderIconsIndexPage() {
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
    }

    public void assertIframeExist() {
        assertThat(indexPage.iframeIsExisted())
            .as("Displaying the iframe “Frame Button” was wrong")
            .isEqualTo(true);
    }

    public void checkIframeButton() {
        assertThat(indexPage.checkIframeButton())
            .as("Displaying “Frame Button” in the iframe was wrong")
            .isEqualTo(true);
    }

    public void assertFiveItemsInLeftSectionAndTexts() {
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

    public void assertLogRows() {
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
