package com.alone.beginning;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Day4 {
	static Logger logger = Logger.getLogger(Day4.class);//클래스명 아래에 사용
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용		
		
		//최대 공약수 구하기
		
		Scanner sc = new Scanner(System.in);
		
		logger.debug("서로 다른 두 정수를 입력하시오");
		
		int n = 0;
		int first = sc.nextInt();
		int second = sc.nextInt();
		int big, small;
		
		if(first > second){
			big = first;
			small = second;
		}else {
			small = first;
			big = second;
		}
		for(int i = 1; i <= small; i++) {
			if (big % i == 0 && small % i == 0) {
				n = i;
			}
		}
		logger.debug("최대 공약 수는" + n);

	}

}
