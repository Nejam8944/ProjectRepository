package com.cg.trg.Spring.springApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.trg.Spring.beans.Student;
import com.cg.trg.Spring.beans.Teacher;

public class App {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
		
//		Teacher t1= ctx.getBean("teacher1",Teacher.class);
//		Teacher t2= ctx.getBean("teacher2",Teacher.class);
		Student s1= ctx.getBean("std1",Student.class);
//		Student s2= ctx.getBean("std2",Student.class);
		
//		System.out.println(t1);
//		System.out.println(t2);
		System.out.println(s1);
//		System.out.println(s2);
 		
		
		
		

	}

}
