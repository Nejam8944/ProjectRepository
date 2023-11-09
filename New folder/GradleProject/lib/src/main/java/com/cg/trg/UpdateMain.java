package com.cg.trg;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-EMP");
		EntityManager em = emf.createEntityManager();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id: ");
		int eid=sc.nextInt();
		
		Employee e=em.find(Employee.class, eid);
		System.out.println("Enter salary to be set: ");
		int sal= sc.nextInt();
		e.setSalary(sal);
		
		em.getTransaction().begin();
		em.merge(e);
		System.out.println("Salary of employee with id: "+eid+" changed to "+e.getSalary());
		
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
