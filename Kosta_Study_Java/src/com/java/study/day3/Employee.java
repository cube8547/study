package com.java.study.day3;


/**
 * 사원 클래스
 * 
 * @author
 * @since 2017.01.11
 */
public class Employee {

	/** 추가 : 정적 클래스 */
	private static int nextId = 1;
	
	private int id;
	private String name;
	private int salary;
	
	/** 추가 : 생성자 오버로딩 */
	public Employee(String name) {
		this.name = name;
		
		/** 정적 필드 공유 */
		id = nextId;
		nextId++;
	}
	
	public Employee(String name, int salary) {
		this(name);
		//this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	
	public String getInformation() {
		String information = "ID: " + id + "이름 : " + "연봉 : " + salary;
		return information;
	}
}
