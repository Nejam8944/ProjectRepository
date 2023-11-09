package com.cg.trg.spring;

import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.w3c.dom.ls.LSOutput;

public class Product {
	private int productId;
	private String name;
	private double price;
	
	@Autowired
	@Qualifier("vendor2")
	private Vender vender;
	
	
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

	public Vender getVender() {
		return vender;
	}

	public void setVender(Vender vender) {
		this.vender = vender;
	}

	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", vender=" + vender + "]";
	}

	public void create() {
		System.out.println("Bean with id "+productId+" is created");
	}
	
	public void destroy() {
		System.out.println("Bean with id "+productId+" is destroyed");
	}
	
	
}
