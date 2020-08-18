package com.multidynamika.javabasic.models;

public class FruitModel {
	public int price, id;
	public String name;

	public FruitModel(int id, String name, int price) {
		this.price = price;
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "{" + "\"price\":" + price + ", \"id\":" + id +
				", \"name\":\"'" + name + '\"' + '}';
	}
}