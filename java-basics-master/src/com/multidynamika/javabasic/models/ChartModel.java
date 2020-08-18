package com.multidynamika.javabasic.models;

public class ChartModel {
    public String name = "", category = "", price = "";

    public ChartModel(String name, String category, String price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" + "\"name\":\"'" + name + '\"' + ", \"category\":\"'" +
                category + '\"' + ", \"price\":\"" + price + "\"}";
    }
}
