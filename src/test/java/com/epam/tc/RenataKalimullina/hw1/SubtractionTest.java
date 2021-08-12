package com.epam.tc.RenataKalimullina.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class SubtractionTest extends TestBase {

    @Test(groups = {"SumSubGroup"},
            dataProviderClass = DataProviders.class,
            dataProvider = "data for subtraction")
    public void testSubtraction(double minuend, double subtrahend, double result) {
        double actual = calculator.sub(minuend, subtrahend);
        assertThat(actual)
                .as("Calculation of the subtraction was wrong")
                .isEqualTo(result);
    }
}
