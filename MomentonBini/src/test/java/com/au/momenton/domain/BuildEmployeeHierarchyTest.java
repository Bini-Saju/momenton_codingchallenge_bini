package com.au.momenton.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.au.momenton.model.Employee;

public class BuildEmployeeHierarchyTest {

	Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

	public Map<Integer, Employee> getEmployees() {
		employees.put(100, new Employee("Alan", 100, 150));
		employees.put(220, new Employee("Martin", 220, 100));
		employees.put(150, new Employee("Jamie", 150, 0));
		employees.put(275, new Employee("Alex", 275, 100));
		employees.put(400, new Employee("Steve", 400, 150));
		employees.put(190, new Employee("David", 190, 400));
		return employees;
	}

	@Test
	public void getSubordinatesByIdTest() {
		
		employees = getEmployees();
		
		List<Employee> subordinates = BuildEmployeeHierarchy.getSubordinatesById(employees, 100);
		assertEquals(2,subordinates.size());
		
		subordinates = BuildEmployeeHierarchy.getSubordinatesById(employees, 150);
		assertEquals(2,subordinates.size());
		
		subordinates = BuildEmployeeHierarchy.getSubordinatesById(employees, 400);
		assertEquals(1,subordinates.size());

		subordinates = BuildEmployeeHierarchy.getSubordinatesById(employees, 220);
		assertEquals(0,subordinates.size());
	}
}
