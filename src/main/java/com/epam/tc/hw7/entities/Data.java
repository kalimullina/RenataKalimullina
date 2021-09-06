package com.epam.tc.hw7.entities;

import java.util.List;

public class Data {

    public List<Integer> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    Data() {

    }

    public Data(List<Integer> summary, List<String> elements,
                String color, String metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }
}
