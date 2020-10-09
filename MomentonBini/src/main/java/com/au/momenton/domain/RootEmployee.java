package com.au.momenton.domain;

import java.util.Map;

import com.au.momenton.model.Employee;

public class RootEmployee {

	// find root employee
	public static Employee findRootEmployee(Map<Integer, Employee> employees) throws Exception {
		for (Employee e : employees.values()) {
			if (e.getManagerId() == 0) {
				return e;
			}
		}
		return null;
	}

}
