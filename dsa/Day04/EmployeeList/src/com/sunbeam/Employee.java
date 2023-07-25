package com.sunbeam;

public class Employee {
	private int empid;
	private String name;
	private double salary;
	public Employee() {
		empid = 0;
		name = null;
		salary = 0;
	}
	public Employee(int empid, String name, double salary) {
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
