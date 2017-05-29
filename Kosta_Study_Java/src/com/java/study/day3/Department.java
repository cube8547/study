package com.java.study.day3;


/**
 * 부서 클래스
 * 
 * @author
 * @since 2017.01.11
 */
public class Department {

	// 필드, 속성
	private String name;
	private Employee[] employeeArr;
	
	// 생성자
	public Department(String name) {
		this.name = name;
	}
	
	// 직원들을 배치한다
	// 행위, 메소드
	public void setEmployeeArr(Employee[] employeeArr) {
		this.employeeArr = employeeArr;
	}
	
	// 직원 검색
	public Employee searchEmployee(String searchName) {
		// employee 검색
		for (Employee employee : employeeArr) {
			String employeeName = employee.getName();
			
			if(employeeName.contains(searchName)) {
				return employee;
			}
		}
		
		return null;
	}
}
