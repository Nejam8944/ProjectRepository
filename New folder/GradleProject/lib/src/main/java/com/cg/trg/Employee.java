package com.cg.trg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="EMPTBL")

@NamedQueries(
		{
			@NamedQuery(name = "getAll",query = "select e from Employee e"),
			@NamedQuery(name = "getOnSalary",query = "select e from Employee e where e.salary between :lowsal and :highsal")
	}
		)

public class Employee {
	@Id
	private int empId;
	private String name;
	private int salary;
	
	public Employee() {
		super();
	}
	public Employee(int empId, String name, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
	

}
