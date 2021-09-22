package com.epam.tc.hw7.entities;

import java.util.List;

public class DataFromJson {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public DataFromJson() {

    }

    public DataFromJson(List<Integer> summary, List<String> elements,
                        String color, String metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public List<Integer> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public String getExpectedResultLog() {

        int summaryResult = summary.get(0) + summary.get(1);

        StringBuilder elementsResult = new StringBuilder(elements.get(0));
        for (int i = 1; i < elements.size(); i++) {
            elementsResult.append(", ").append(elements.get(i));
        }

        StringBuilder vegetablesResult = new StringBuilder(vegetables.get(0));
        for (int i = 1; i < vegetables.size(); i++) {
            vegetablesResult.append(", ").append(vegetables.get(i));
        }

        return "Summary: " + summaryResult + "\n"
            + "Elements: " +  elementsResult + "\n"
            + "Color: " + color + "\n"
            + "Metal: " + metals + "\n"
            + "Vegetables: " +  vegetablesResult;
    }
}
