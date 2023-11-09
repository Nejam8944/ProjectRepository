package com.cg.trg;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindMain {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-EMP");
		EntityManager em = emf.createEntityManager();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Employee Id");
		int eid=sc.nextInt();
		
		Employee x=em.find(Employee.class, eid);
		if(x==null)
			System.out.println("Employee with id: "+eid+" Not found");
		else
			System.out.println(x);
		
		em.close();
		emf.close();
	}

}
