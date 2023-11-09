package com.cg.trg.boot.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement 
public class Employee {

	@Id
	@NotNull(message = "Employee ID id required")
	@Min(value= 100,message = "Employee Id cannot be less than 100")
	@Max(value= 999,message = "Employee Id cannot be more than 999")
	private Integer empid;
	
	@Column(length = 20)
	@Size(min = 5,max = 15,message = "Name should be minimum 5 characters and maximum 15 chars")
	private String name;
	
	private LocalDate dob;
	
	@Min(value= 10000,message = "Salary cannot be less than 10000")
	@Max(value= 50000,message = "Salary cannot be more than 50000")
	private int salary;
	
	
	public Employee() {
		super();
	}
	
	public Employee(int empid, String name, LocalDate dob, int salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", dob=" + dob + ", salary=" + salary + "]";
	}
	
	

}
