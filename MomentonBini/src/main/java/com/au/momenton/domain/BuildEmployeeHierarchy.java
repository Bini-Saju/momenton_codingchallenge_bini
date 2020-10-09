package com.au.momenton.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.au.momenton.model.Employee;

public class BuildEmployeeHierarchy {

	// build hierarchy recursively
	public static void buildEmployeeHierarchy(Employee subRoot, Map<Integer, Employee> employees) {
		Employee employee = subRoot;
		
		List<Employee> subordinates = getSubordinatesById(employees, employee.getId());
		employee.setSubordinates(subordinates);
		if (subordinates.size() == 0) {
			return;
		}

		for (Employee e : subordinates) {
			buildEmployeeHierarchy(e, employees);
		}
	}

	// scan whole employee list to form a list of subordinates for the given id
	public static List<Employee> getSubordinatesById(Map<Integer, Employee> employees, int managerId) {
		List<Employee> subordinates = new ArrayList<Employee>();
		for (Employee e : employees.values()) {			
			if (e.getManagerId() == managerId) {
				subordinates.add(e);
			}
		}
		return subordinates;
	}

	// print hierarchy recursively
	public static void printEmployeeHierarchy(Employee subRoot, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("\t");
		}
		System.out.println(subRoot.getName());

		List<Employee> subordinates = subRoot.getSubordinates();
		System.out.print(" ");
		for (Employee e : subordinates) {
			printEmployeeHierarchy(e, level + 1);
		}
	}
}
