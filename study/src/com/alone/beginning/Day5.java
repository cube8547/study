package com.alone.beginning;

//정수를 입력받아 2진수로 출력하기
//logger.debug는 사용 안됨

//키보드로부터 0보다 큰 임의의 정수를입력하고 이 정수를 이진수로 출력하고 이진수에 들어있는 1의 개수를 출력

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Day5 {
	static Logger logger = Logger.getLogger(Day5.class);//클래스명 아래에 사용

	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용				
		
		System.out.println("0보다 큰 임의의 정수 입력하세요.");
		Scanner ch = new Scanner(System.in);

		int array[] = new int[10];
		int num = ch.nextInt();
		int count = 0;
		int j = 0;

		for (int i = 0; i <= array.length - 1; i++) {
			if (num % 2 == 1) {
				count++;
				array[i] = 1;
				num = num / 2;
			} else if (num % 2 == 0) {
				array[i] = 0;
				num = num / 2;
			}
		}
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == 1) {
				j = i;
				break;
			}
		}
		for (; j >= 0; j--) {
			System.out.print(array[j]);
		}
		System.out.println("1의 갯수는 : " + count);
		
		/*logger.debug("0보다 큰 임의의 정수 입력하세요.");
		Scanner ch = new Scanner(System.in);
		
		int array[] = new int[10];
		int num = ch.nextInt();
		int count = 0;
		int j = 0;
		
		for (int i = 0; i <= array.length - 1; i++) {
			if (num % 2 == 1) {
				count++;
				array[i] = 1;
				num = num / 2;
			} else if (num % 2 == 0) {
				array[i] = 0;
				num = num / 2;
			}
		}
		
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == 1) {
				j = i;
				break;
			}
		}
		
		for (; j >= 0; j--) {
			System.out.print(array[j]);
		}
		logger.debug("");
		logger.debug("1의 갯수는 : " + count);*/
		





	}

}
