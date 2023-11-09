package com.cg.trg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import antlr.collections.List;

public class NamedQueryMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-EMP");
		EntityManager em = emf.createEntityManager();
		
		javax.persistence.Query nq1= em.createNamedQuery("getAll");
		
		javax.persistence.Query nq2=em.createNamedQuery("getOnSalary");

		
		java.util.List<Employee> list1=nq1.getResultList();
		list1.forEach(System.out::println);
		
		
		System.out.println("===========Employee getting salary between 10000 and 25000");
		nq2.setParameter("lowsal", 2000);
		nq2.setParameter("highsal", 36000);
		
		java.util.List<Employee> list2=nq2.getResultList();
		list2.forEach(System.out::println);
	}

}
