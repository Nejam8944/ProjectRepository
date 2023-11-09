package com.cg.trg.Spring.beans;

public class Teacher {

	private int teacherId;
	private String name;
	private int salary;
	
	public Teacher() {
		super();
	}
	
	public Teacher(int teacherId, String name, int salary) {
		super();
		this.teacherId = teacherId;
		this.name = name;
		this.salary = salary;
	}

	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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
		return "Teacher [teacherId=" + teacherId + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
}
