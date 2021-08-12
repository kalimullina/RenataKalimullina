package com.epam.tc.RenataKalimullina.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;


public class SumTest extends TestBase {

    @Test(groups = {"SumSubGroup"},
            dataProviderClass = DataProviders.class,
            dataProvider = "data for sum")
    public void testSum(double termFirst, double termSecond, double result) {
        double actual = calculator.sum(termFirst, termSecond);
        assertThat(actual)
                .as("Calculation of the sum was wrong")
                .isEqualTo(result);
    }
}
