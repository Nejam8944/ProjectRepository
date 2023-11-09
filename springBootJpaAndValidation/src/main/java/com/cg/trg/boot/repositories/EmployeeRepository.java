package com.cg.trg.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.trg.boot.dto.Employee;

@Repository//(not required. boot automatically locates this)
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
}
