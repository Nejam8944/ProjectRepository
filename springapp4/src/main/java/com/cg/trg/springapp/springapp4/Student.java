package com.cg.trg.springapp.springapp4;

public class Student {

	private int studentId;
	private String name;
	private double marks;
//	@Autowired
//	@Qualifier(value="teacher1")
	private Teacher teacher;
	
	public Student() {
		super();
	}

	public Student(int studentId, String name, Teacher teacher, double marks) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.teacher = teacher;
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", teacher=" + teacher + ", marks=" + marks + "]";
	}
	
	
	
}
