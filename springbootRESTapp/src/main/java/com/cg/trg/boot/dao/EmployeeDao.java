package com.cg.trg.boot.dao;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.exceptions.DuplicateEmployeeException;
@Service
public interface EmployeeDao {
	
	void save(Employee e)  throws DuplicateEmployeeException;
	boolean update(Employee e);
	boolean delete(int empId);
	Employee getEmployee(int empId);
	Collection<Employee> getAllEmployees();

}
