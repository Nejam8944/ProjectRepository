package com.cg.trg.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args ) {
    	AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext( AppConfig.class);
    	
    	

    		
    		
    	
    	Product p= ctx.getBean("prd1",Product.class); 
    
    	
    	System.out.println(p);
    	ctx.close();
    	
    }
}
