package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class EmployeeController   
{  
	@Autowired  
	private EmployeeService empService;  
	
	
	@GetMapping(value = "/api/employees")  
	public List<Employee> getEmployeeData()   
	{  
		//finds all the products  
		List<Employee> emps = empService.getEmployees();  
		//returns the product list  
		return emps;  
	}  
	
	@PostMapping(value = "/api/employees")  
	public List<Employee> createEmployeeData(@RequestBody Employee employee) throws Exception {
		
		if(employee == null) {
			throw new Exception("No Request Body to save data");
		}
		List<Employee> emps = empService.saveEmployee(employee);  
		return emps;
	}
	
	@GetMapping("/api/employees/{id}/tax")
	public String getEmployeeTax(@PathVariable(value = "id") String employeeId) throws Exception {
		
		String empTaxStatus = empService.getEmployeeTaxByEmpId(employeeId);  
		return empTaxStatus;
	}
	
}  

