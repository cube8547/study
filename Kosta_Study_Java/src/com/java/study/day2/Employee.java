package com.java.study.day2;

/**
 * 사원 클래스
 * 
 * @author
 * @since 2017.01.11
 */
public class Employee {

	private int id;
	private String name;
	private int salary;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
}
