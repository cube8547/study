package com.java.study.day4.domain;


/**
 * 사원 클래스
 * 
 * @author
 * @since 2017.01.11
 */
public class Employee {

	// 정적변수 (모든 객체들이 공유해서 사용)
	private static int nextId = 1;
	
	private int id;
	private String name;
	private int salary;
	private Gender gender;
	
	public Employee(String name) {
		this.name = name;
		
		id = nextId;
		nextId++;
	}
	
	public Employee(String name, int salary) {
		// 자신의 생성자 호출
		this(name);
		//this.name = name;
		this.salary = salary;
	}

	/**
	 * 자신의 정보를 문자열로 넘겨주는 메소드
	 * @return
	 */
	public String getInformation() {
		String information = "ID: " + id + "이름: " + "연봉: " + salary;
		return information;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
