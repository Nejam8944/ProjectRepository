package com.cg.trg.Spring.beans;

import java.util.Objects;

public class Product {
	private int productId;
	private String name;
	private double price;
	
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}
	
	public void create() {
		System.out.println("Bean with id "+productId+" is created");
	}
	
	public void destroy() {
		System.out.println("Bean with id "+productId+" is destroyed");
	}
	@Override
	public int hashCode() {
		return Objects.hash(name,productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& productId == other.productId;
	}
	
	
}
