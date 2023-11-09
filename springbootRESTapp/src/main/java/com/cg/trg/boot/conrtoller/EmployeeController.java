package com.cg.trg.boot.conrtoller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.trg.boot.dto.AppResponse;
import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	 
	@Autowired
	EmployeeService service;
	
	@GetMapping()
//	@RequestMapping(method = RequestMethod.GET)
	public Collection<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@GetMapping(value = "{eid}")
	public ResponseEntity<?> getEmployee(@PathVariable("eid") int empId) {
		Employee e= service.getEmployee(empId);
		if(e!=null)
			return new ResponseEntity<Employee>(e,HttpStatus.OK);
		else 	
			return new ResponseEntity<AppResponse>(new AppResponse("NOTFND", "Employee with "+empId+"not Found"),HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody Employee e){
		boolean saved = service.addEmployee(e);
		AppResponse resp;
		if(saved) {
			resp= new AppResponse("SAVESUCCESS", "Employee with "+e.getEmpid()+"Successfully saved");
			return new ResponseEntity<AppResponse>(resp,HttpStatus.CREATED);
			
			}
		else {
			resp= new AppResponse("SAVEFAIL", "Employee with "+e.getEmpid()+"Already Exits");
			return new ResponseEntity<AppResponse>(resp,HttpStatus.CONFLICT);
			
		}
		
	}
	
	
	@PutMapping()
	public ResponseEntity<?> updateEmployee(@RequestBody Employee e){
		boolean update = service.updateEmployee(e);
		AppResponse resp;
		if(update) {
			resp= new AppResponse("UPDATESUCCESS", "Employee with "+e.getEmpid()+" Successfully updated");
			return new ResponseEntity<AppResponse>(resp,HttpStatus.CREATED);
			
		}
		else {
			resp= new AppResponse("UPDATEFAIL", "Employee with "+e.getEmpid()+" not updated");
			return new ResponseEntity<AppResponse>(resp,HttpStatus.CONFLICT);
			
		}
		
	}
	
	@DeleteMapping(value = "{eid}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("eid") int empId) {
		boolean delete = service.deleteEmployee(empId);
		AppResponse resp;
		
		if(delete) {
			
			resp= new AppResponse("DLTSUCCESS", "Employee with "+empId+" successfully deleted");
			return new ResponseEntity<AppResponse>(resp,HttpStatus.CREATED);
		}
		else {
			resp= new AppResponse("DLTFAIL", "Employee with "+empId+" not deleted");
			return new ResponseEntity<AppResponse>(new AppResponse("NOTFND", "Employee with "+empId+" not Found"),HttpStatus.ACCEPTED);
		}
		
	}
	
	
	
	
}
 