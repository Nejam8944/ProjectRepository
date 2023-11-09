package com.cg.trg;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class PersistMain {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-EMP");
		EntityManager em = emf.createEntityManager();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id");
		int eid= sc.nextInt();
		
		System.out.println("Enter Employee name");
		String name= sc.next();
		
		
		System.out.println("Enter Employee salary");
		int sal= sc.nextInt();
		
		Employee e = new Employee(eid, name, sal);
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("Data inserted succesfully");
		
		em.close();
		emf.close();
		

	}

}
