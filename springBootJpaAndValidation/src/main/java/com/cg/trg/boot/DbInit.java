package com.cg.trg.boot;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.repositories.EmployeeRepository;

@Component
public class DbInit implements CommandLineRunner{
	@Autowired
	EmployeeRepository repo;
	
	Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Employee(100, "Kishore", LocalDate.of(1989, 12, 21), 24000));
		repo.save(new Employee(200, "Kirthi", LocalDate.of(1992, 5, 15), 44000));
		repo.save(new Employee(300, "Ashok", LocalDate.of(1995, 2, 2), 25000));
		repo.save(new Employee(400, "Rajesh", LocalDate.of(1996, 1, 15), 36000));
		
		logger.info("Database started with 4 employee");
		logger.warn("Database will be deleted when u start the program");
	}
	
	

}
