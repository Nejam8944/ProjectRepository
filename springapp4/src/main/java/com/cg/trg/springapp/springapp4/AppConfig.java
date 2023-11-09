package com.cg.trg.springapp.springapp4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name = "std1")
	public Student getStudent() {
		Student st = new Student();
		st.setMarks(98.7); 
		st.setName("Vikash");
		st.setTeacher(getTeacher1());
		st.setStudentId(111);
		return st;

	}

	@Bean(name = "std2")
	public Student getStudent1() {
		Student st = new Student();
		st.setMarks(98.8);
		st.setName("Rahul");
		st.setTeacher(getTeacher2());
		st.setStudentId(100);
		return st;

	}

	@Bean(name = "teacher1")
	public Teacher getTeacher1() {
		Teacher t=new Teacher();
		t.setName("Akash");
		t.setSalary(25000);
		t.setTeacherId(200);
		return t;
	}
	
	@Bean(name = "teacher2")
	public Teacher getTeacher2() {
		Teacher t = new Teacher();
		t.setName("Madan");
		t.setSalary(67000);
		t.setTeacherId(400);
		return t;

	}

}
