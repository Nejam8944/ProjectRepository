package com.cg.trg.springapp.springapp4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	Student st1= ctx.getBean("std1",Student.class);
    	Student st2= ctx.getBean("std2",Student.class);
    	System.out.println(st1);
    	System.out.println(st2);
    }
}
