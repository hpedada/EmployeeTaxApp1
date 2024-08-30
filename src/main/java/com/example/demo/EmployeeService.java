package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	public ArrayList<Employee> getEmployees(){
		ArrayList<String> phNum1 = new ArrayList<String>();
		phNum1.add("1234567891");
		phNum1.add("0987654321");
		ArrayList<String> phNum2 = new ArrayList<String>();
		phNum2.add("1234567892");
		phNum2.add("0987654321");
		Employee e1 = new Employee("E121", "John1", "Doe", "john1.doe@example.com", phNum1, "2023-05-17", 40000);
		Employee e2 = new Employee("E122", "John2", "Doe", "john2.doe@example.com", phNum1, "2023-05-18", 60000);
		
		ArrayList<Employee> elist = new ArrayList<Employee>();
		elist.add(e1);
		elist.add(e2);
		
		return elist;
	}
	
	public ArrayList<EmployeeTax> getEmployeesTax(){
		EmployeeTax et1 = new EmployeeTax("E122", "John1", "Doe", 20000, 25500, 2000);
		EmployeeTax et2 = new EmployeeTax("E123", "John", "Doe", 70000, 40500, 7000);
		EmployeeTax et3 = new EmployeeTax("E121", "John4", "Doe", 60000, 37500, 6000);
		EmployeeTax et4 = new EmployeeTax("E124", "John2", "Doe", 45000, 27000, 2500);
		
		ArrayList<EmployeeTax> etlist = new ArrayList<EmployeeTax>();
		etlist.add(et1);
		etlist.add(et2);
		etlist.add(et3);
		etlist.add(et4);
		
		return etlist;
	}
	
	public List<Employee> saveEmployee(Employee emp) throws Exception{
		ArrayList<Employee> elist = getEmployees();

		try {
			elist.add(emp);
		} catch(Exception ex) {
			throw new Exception("Error while saving record "+ex);
		}
		
		return elist;
	}

	public String getEmployeeTaxByEmpId(String empId) throws Exception{
		ArrayList<EmployeeTax> etlist = getEmployeesTax();
		List<EmployeeTax> etax = null;
		String taxStatus="";
		try {
			etax = etlist.stream().filter(e -> e.getEmployeeId().equals(empId)).collect(Collectors.toList());
		} catch(Exception ex) {
			throw new Exception("Error while fetching record "+ex);
		}
		
		if(etax.get(0).getYearlySalary()*12 < 250000) {taxStatus = "No Tax";}
		else {taxStatus="Taxable";}
		
		return taxStatus;
	}
	
}

