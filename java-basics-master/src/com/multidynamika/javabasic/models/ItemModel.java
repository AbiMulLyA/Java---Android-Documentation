package com.multidynamika.javabasic.models;

public class ItemModel {
    public int id, qty, price;
    public String name;

    public ItemModel(int id, String name, int qty, int price) {
        this.price = price;
        this.qty = qty;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + "\"id\":" + id + ", \"qty\":" + qty + ", \"price\":" + price + ", \"name\":\"" + name + "\"}";
    }
}
