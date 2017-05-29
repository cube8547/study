package com.java.study.day1;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("num1 : ");
		int num1 = scanner.nextInt();
		
		System.out.print("num2 : ");
		int num2 = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("1. 덧셈, 2. 뺄셈, 3. 곱셈, 4. 나눗셈: ");
		String choice = scanner.nextLine();
		
		double result = 0;
		
		switch(choice) {
		case "1" : 
			result = num1 + num2;
			break;
		
		case "2" :
			result = num1 - num2;
			break;
			
		case "3" :
			result = num1 * num2;
			break;
			
		case "4" :
			result = num1 / num2;
			break;
			
		default :
			System.out.println("잘못 입력 하셨습니다");
		}
		
		System.out.println("연산 결과 : " + result);
	}

}
