package com.java.study.day4.repository;

import com.java.study.day4.domain.Department;
import com.java.study.day4.domain.Employee;

/**
 * 데이터 여역을 다루는 객체
 */
public class EmployeeDao {

	// 정적 상수
	public static final int EMPLOYEE_MAX_LENGTH = 5;
	
	// 부서
	private Department department;	
	
	public EmployeeDao() {
		// 데이터 초기화
		putData();
	}
	
	public void putData() {
		department = new Department("자바개발부서");
		
		// 5만큼 할당
		Employee[] employeeArr = new Employee[EMPLOYEE_MAX_LENGTH];
		employeeArr[0] = new Employee("공유", 1000);
		employeeArr[1] = new Employee("이동욱", 2000);
		employeeArr[2] = new Employee("김고은", 3000);
		
		// 부서에 직원들 세팅
		department.setEmployeeArr(employeeArr);
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}
}
