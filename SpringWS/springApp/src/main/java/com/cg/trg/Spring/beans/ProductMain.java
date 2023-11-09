package com.cg.trg.Spring.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
		
		Product p1=ctx.getBean("prd1",Product.class);
//		Product p2=ctx.getBean("prd1",Product.class);
		System.out.println(p1.hashCode());
//		System.out.println(p1==p2);
		ctx.close();
		System.out.println("Application completed");
		
	}

}
