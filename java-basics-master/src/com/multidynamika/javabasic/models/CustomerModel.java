package com.multidynamika.javabasic.models;

public class CustomerModel {
    public int id;
    public String name;

    public CustomerModel(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" + "\"id\":" + id + ", \"name\":\"" + name + '\"' + '}';
    }
}
