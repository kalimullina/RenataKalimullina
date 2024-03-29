package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.data.DataProviders;
import org.testng.annotations.Test;

public class DivisionTest extends TestBase  {

    @Test(groups = {"MultDivGroup"},
            dataProviderClass = DataProviders.class,
            dataProvider = "data for division")
    public void testDivision(double dividend, double divider, double result) {
        double actual = calculator.div(dividend, divider);
        assertThat(actual)
                .as("Calculation of the multiplication was wrong")
                .isEqualTo(result);
    }
}
