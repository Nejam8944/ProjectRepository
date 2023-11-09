package com.cg.trg.boot.dao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.trg.boot.dto.AppResponse;
import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.exceptions.DuplicateEmployeeException;
import com.cg.trg.boot.exceptions.EmployeeNotFoundException;
import com.cg.trg.boot.repositories.EmployeeRepository;

@Service
public class EmployeeJpaDaoImpl implements EmployeeDao {
	@Autowired
	EmployeeRepository repo;

	

	@Override
	public void save(Employee e) {
		Optional<Employee> opt = repo.findById(e.getEmpid());
		if (!opt.isEmpty()) {
			AppResponse resp = new AppResponse("SAVEFAIL", "Employee with id " + e.getEmpid() + " already exits");
			throw new DuplicateEmployeeException(resp);

		}
		repo.save(e);


	}

	@Override
	public boolean update(Employee e) {
		Optional<Employee> opt = repo.findById(e.getEmpid());
		if (opt.isEmpty()) {
			AppResponse resp = new AppResponse("UPDTFAIL", "Employee with id " + e.getEmpid() + " does not exist");
			throw new EmployeeNotFoundException(resp);

		}
		repo.save(e);
		return true;

	}

	@Override
	public boolean delete(int empId) {
		Optional<Employee> opt = repo.findById(empId);
		if (opt.isEmpty()) {
			AppResponse resp = new AppResponse("DELFAIL", "Employee with id " + empId + " does not exist");
			throw new EmployeeNotFoundException(resp);

		}
		repo.deleteById(empId);
		return true;
	}

	@Override
	public Employee getEmployee(int empId) {
		Optional<Employee> opt = repo.findById(empId);
		if (opt.isEmpty()) {
			AppResponse resp = new AppResponse("FAIL", "Employee with id " + empId + " does not exist");
			throw new EmployeeNotFoundException(resp);

		}
		return opt.get();

	}

	@Override
	public Collection<Employee> getAllEmployees() {
		Collection<Employee> col = repo.findAll();
		return col;
	}

}
