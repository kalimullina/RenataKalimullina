package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.data.DataProviders;
import org.testng.annotations.Test;

public class MultiplicationTest extends TestBase {

    @Test(groups = {"MultDivGroup"},
            dataProviderClass = DataProviders.class,
            dataProvider = "data for multiplication")
    public void testMultiplication(double multiplierFirts, double multiplierSecond, double result) {
        double actual = calculator.mult(multiplierFirts, multiplierSecond);
        assertThat(actual)
                .as("Calculation of the multiplication was wrong")
                .isEqualTo(result);
    }
}
