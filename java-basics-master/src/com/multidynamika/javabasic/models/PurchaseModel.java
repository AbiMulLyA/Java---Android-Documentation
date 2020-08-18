package com.multidynamika.javabasic.models;

import java.util.List;

public class PurchaseModel {
    public String orderId, createdAt;
    public CustomerModel customer;
    public List<ItemModel> items;

    public PurchaseModel(String orderId, String createdAt, CustomerModel customer, List<ItemModel> items) {
        this.createdAt = createdAt;
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
    }

    @Override
    public String toString() {
        return "{" + "\"orderId\":\"" + orderId + '\"' + ", \"createdAt\":\"" + createdAt + '\"' + ", \"customer\":" + customer +
                ", \"items\":" + items + '}';
    }
}
