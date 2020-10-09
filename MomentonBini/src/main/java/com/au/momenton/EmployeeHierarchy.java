package com.au.momenton;

import java.util.List;
import java.util.Map;

import com.au.momenton.domain.BuildEmployeeHierarchy;
import com.au.momenton.domain.InvalidManagers;
import com.au.momenton.domain.RootEmployee;
import com.au.momenton.model.Employee;
import com.au.momenton.utils.CsvLoader;

public class EmployeeHierarchy {

	static Map<Integer, Employee> employees;
	static Employee root;

	public static void main(String[] args) {

		CsvLoader csvLoader = new CsvLoader();
		try {
			//read source file
			employees = csvLoader.loadFromResource("/employee_data.csv", true);
			
			//find if the managers are valid employees
			InvalidManagers.findInvalidManagers(employees);
			
			//root employee of the hierarchy, employee with no manager
			root = RootEmployee.findRootEmployee(employees);
			if(root != null) {
				BuildEmployeeHierarchy.buildEmployeeHierarchy(root, employees);	
				BuildEmployeeHierarchy.printEmployeeHierarchy(root, 0);
			}
			else {
				throw new Exception("No Root Employee Found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
