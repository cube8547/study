package com.java.study.day4.domain;


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
	
	// 직원들을 배치한다.
	// 행위, 메소드
	public void setEmployeeArr(Employee[] employeeArr) {
		this.employeeArr = employeeArr;
	}
	
	// 직원 검색
	public Employee searchEmployee(String searchName){
		// employee 탐색
		for (Employee employee : employeeArr) {
			String employeeName = employee.getName();
			
			if(employeeName.contains(searchName)) {
				return employee;
			}
		}
		
		return null;
	}

	// 직원 추가
	public Employee addEmployee(Employee newEmployee) {
		int newIndex = 0;
		
		for (int i = 0; i < employeeArr.length; i++) {
			// 직원 객체가 없으면
			if(employeeArr[i] == null) {
				// 새로운 직원 추가
				employeeArr[i] = newEmployee;
				newIndex = i;
				break;
			}
		}
		
		return employeeArr[newIndex];
	}
}
