package com.cg.trg.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.cg")
public class AppConfig {
	
	@Bean (name="prd1")
	@Scope(scopeName = "prototype")
	public Product getProduct() {
		Product p= new Product();
		p.setProductId(111);
		p.setName("television");
		p.setPrice(45000);
		return p;
	}
	
	@Bean(name = "vendor1")
	@Scope(scopeName = "prototype")
	public Vender getVendor1() {
		Vender v = new Vender();
		v.setVendorId(111);
		v.setName("Electronics Ltd");
		return v;
	}
	
	@Bean(name = "vendor2")
	@Scope(scopeName = "prototype")
	public Vender getVendor2() {
		Vender v = new Vender();
		v.setVendorId(222);
		v.setName("Shreyas Ltd");
		return v;
	}
	
	

}
