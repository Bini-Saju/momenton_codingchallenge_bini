package com.au.momenton.domain;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import com.au.momenton.model.Employee;

public class InvalidManagersTest {

	@Test
    public void findInvalidManagersTest() throws Exception {
		Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
		employees.put(100, new Employee("Alan",100, 150));
		employees.put(220, new Employee("Martin",220, 100));
		employees.put(150, new Employee("Jamie",150, 0));
		employees.put(275, new Employee("Alex",275, 100));
		employees.put(400, new Employee("Steve",400, 150));
		employees.put(190, new Employee("David",190, 500));

       
        Employee employee = InvalidManagers.findInvalidManagers(employees);
        assertNotNull(employee);
    }
}
