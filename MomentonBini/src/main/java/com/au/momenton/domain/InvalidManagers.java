package com.au.momenton.domain;

import java.util.Map;

import com.au.momenton.model.Employee;

public class InvalidManagers {

	public static Employee findInvalidManagers(Map<Integer, Employee> employees) throws Exception {
		//find if the managers are valid employees
		for (Employee e : employees.values()) {
			if(e.getManagerId() != 0)
			{
				if(employees.get(e.getManagerId()) == null) {
					throw new Exception("Manager with id: "+ e.getManagerId() + " is not a valid employee");
				}
			}
		}
		return null;
		
	}
}
