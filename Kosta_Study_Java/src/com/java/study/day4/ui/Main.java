package com.java.study.day4.ui;


import java.util.Scanner;

import com.java.study.day4.domain.Department;
import com.java.study.day4.domain.Employee;
import com.java.study.day4.repository.EmployeeDao;



/**
 * 입출력을 담당하는 클래스
 */
public class Main {

	// 실행의 시작점
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 기초데이터 생성
		EmployeeDao employeeDao = new EmployeeDao();
		
		System.out.print("직원명을 입력해주세요 : ");
		String searchName = scanner.nextLine();
		
		Department department = employeeDao.getDepartment();
		
		// 부서에게 직원 검색 위임
		Employee employee = department.searchEmployee(searchName);
		
		System.out.println("검색된 직원명 : " + employee.getName());
		System.out.println("추가할 직원의 정보를 입력해주세요");
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		System.out.print("연봉 : ");
		int salary = scanner.nextInt();
		
		Employee newEmployee = new Employee(name, salary);
		Employee addedEmployee = department.addEmployee(newEmployee);
		System.out.println(addedEmployee.getInformation());
		
		scanner.close();
	}
}
