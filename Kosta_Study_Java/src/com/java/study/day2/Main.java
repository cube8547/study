package com.java.study.day2;

import java.util.Scanner;

public class Main {

	// 부서
	private static Department department;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 기초 데이터 생성
		putData();
		
		System.out.print("직원명을 입력해 주세요 : ");
		String searchName = scanner.nextLine();
		
		// 부서에게 직원 검색 위임
		Employee employee = department.searchEmployee(searchName);
		
		System.out.print("검색된 직원명: " + employee.getName());
	}

	/**
	 * 기초 데이터 생성
	 */
	private static void putData() {
		department = new Department("자바 개발 부서");
		
		Employee[] employeeArr = new Employee[3];
		employeeArr[0] = new Employee("공유", 1000);
		employeeArr[1] = new Employee("이동욱", 2000);
		employeeArr[2] = new Employee("김고은", 3000);
		
		department.setEmployeeArr(employeeArr);
	}

}
