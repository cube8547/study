package com.java.study.day1;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("출력할 숫자 : ");
		int number = scanner.nextInt();

		System.out.print("한 줄에 반복 횟수 : ");
		int numberRepeat = scanner.nextInt();
		
		System.out.print("반복출력할 라인 수: ");
		int lineRepeat = scanner.nextInt();
		
		for (int i = 0; i < lineRepeat ; i++) {
			for (int j = 0; j < numberRepeat; j++) {
				System.out.print(number);
			}
			System.out.println();
		}
	}

}
