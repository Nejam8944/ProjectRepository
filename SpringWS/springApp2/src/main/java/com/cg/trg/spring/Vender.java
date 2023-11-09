package com.cg.trg.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

public class Vender {
	private int vendorId;
	private String  name;
	
	public Vender() {
		super();
	}

	public Vender(int vendorId, String name) {
		super();
		this.vendorId = vendorId;
		this.name = name;
	}
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Vender [vendorId=" + vendorId + ", name=" + name + "]";
	}
	
	@PostConstruct
	public void vendorCreate() {
		System.out.println("vendor object with id "+vendorId+" created");
	}
	@PreDestroy
	public void vendorDestroye() {
		System.out.println("vendor object with id "+vendorId+" destroyed");
	}
	
	

}
