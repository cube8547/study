package com.java.study.day1;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] numberArr = new int[5];
		int addition = 0;
		double average = 0;

		for (int i = 0; i < numberArr.length; i++) {
			System.out.print(i+1 + "번째 정수 입력 : ");
			numberArr[i] = scanner.nextInt();
		}
		
		for (int i : numberArr) {
			addition += i;
		}
		average = addition / numberArr.length;
		
		System.out.println("평균 : " + addition);
		System.out.println("합계 : " + average);
	}

}
