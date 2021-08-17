package com.epam.tc.hw1.data;

import org.testng.annotations.DataProvider;


public class DataProviders {

    @DataProvider(name = "data for division")
    public static Object[][] dataForDivision() {
        return new Object[][] {
                {0, 678, 0}, {287, 287, 1}, {300, 5, 60}, {-413, 7, -59},
                {-552, -69, 8}, {5., 100., 0.05} };
    }

    @DataProvider(name = "data for multiplication")
    public static Object[][] dataForMultiplication() {
        return new Object[][] {
                {0, 678, 0}, {287, 2, 574}, {-28, 10, -280}, {-5, -40, 200},
                {-0.25, 4, -1}, {0.1, 10., 1.} };
    }

    @DataProvider(name = "data for subtraction")
    public static Object[][] dataForSubtraction() {
        return new Object[][] {
                {0, 678, -678}, {287, 2, 285}, {-28, 10, -38}, {-5, -40, 35},
                {-0.25, 4, -4.25}, {0.1, 10., -9.9} };
    }

    @DataProvider(name = "data for sum")
    public static Object[][] dataForSum() {
        return new Object[][] {
                {0, 678, 678}, {287, 2, 289}, {-28, 10, -18}, {-5, -40, -45},
                {-0.25, 4, 3.75}, {0.1, 10., 10.1} };
    }
}
