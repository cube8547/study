package com.java.study.day1;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어 점수 : ");
		int score1 = scanner.nextInt();
		
		System.out.print("영어 점수 : ");
		int score2 = scanner.nextInt();
		
		System.out.print("수학 점수 : ");
		int score3 = scanner.nextInt();
		
		double average = (score1 + score2 + score3) / 3;
		System.out.println("평균 : " + average);
		
		if(average >= 90) {
			System.out.println("A학점");
		} else if(average >= 80 ) {
			System.out.println("B학점");
		} else if(average >= 70 ) {
			System.out.println("C학점");
		} else {
			System.out.println("D학점");
		}
	}

}
