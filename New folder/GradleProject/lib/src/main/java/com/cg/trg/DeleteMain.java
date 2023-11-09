package com.cg.trg;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteMain {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-EMP");
		EntityManager em = emf.createEntityManager();
		Scanner sc=new Scanner(System.in);
		
		em.getTransaction().begin();
		
		System.out.println("Enter Employee Id to delete");
		int eid=sc.nextInt();
		
		Employee x=em.find(Employee.class, eid);
		if(x==null)
			System.out.println("Employee with id: "+eid+" Not found");
		else {
			em.remove(x);
		    System.out.println("Employee with id: "+eid+" succesfully deleted");
		}
		
		
		
		em.close();
		emf.close();

	}

}
