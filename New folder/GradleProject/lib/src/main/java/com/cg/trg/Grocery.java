package com.cg.trg;

public class Grocery {
	private String fruit;
	private double price;
	private double total;
	public Grocery(String fruit, double price, double total) {
		super();
		this.fruit = fruit;
		this.price = price;
		this.total = total;
	}
	public String getFruit() {
		return fruit;
	}
	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
