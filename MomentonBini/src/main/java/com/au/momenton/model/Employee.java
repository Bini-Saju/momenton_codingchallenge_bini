package com.au.momenton.model;

import java.util.List;

public class Employee {

	private String name;
	private int id;
	private int managerId;

	List<Employee> subordinates;

	public Employee(String name, int id, int managerId) {
		try {
			this.name = name;
			this.id = id;
			this.managerId = managerId;
		}
		catch(Exception e){
			System.err.println("Exception creating employee:" + e);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	  @Override
	    public String toString() {
	        return "Employee{" +
	                "name='" + name + '\'' +
	                ", id='" + id + '\'' +
	                ", managerId='" + managerId + '\'' +
	                '}';
	    }
}
