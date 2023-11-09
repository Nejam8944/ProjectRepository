package com.cg.trg;

import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpqlMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-EMP");
		EntityManager em = emf.createEntityManager();
		//create query object
//		Query q= em.createQuery("Select e from Employee e where e.salary>25000");
//		
//		//Run query which return list
//		//getResultList() for multiple object.
//		//getSingleResult() for single object
//		
//		List<Employee> list = q.getResultList();
//		
//		list.stream().sorted(Comparator.comparing(Employee::getEmpId)).forEach(System.out::println);
//		System.out.println("===========query for single object==============");
//		
//		Query q1= em.createQuery("Select e from Employee e where e.empId=111");
//		Employee e=(Employee) q1.getSingleResult();
//		
//		System.out.println(e);
//		
		Query q3= em.createQuery("Select e from Employee e where e.salary between : lowsal and :highsal");
		q3.setParameter("lowsal", 10000);
		q3.setParameter("highsal", 25000);
		List<Employee> list = q3.getResultList();
		list.stream().sorted(Comparator.comparing(Employee::getEmpId)).forEach(System.out::println);
		
		em.close();
		emf.close();
		
	}

}
