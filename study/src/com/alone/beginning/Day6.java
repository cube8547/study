package com.alone.beginning;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//369게임 1~99까지 정수 입력받고 정수에 3, 6, 9 중 하나가 있는 경우 "짝" 두개 "짝짝" 출력.


public class Day6 {
	static Logger logger = Logger.getLogger(Day6.class);//클래스명 아래에 사용

	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			logger.debug("1~99사이의 정수를 입력하세요(종료는 ctrl+z)");
			
			int num = sc.nextInt();
			int count = 0;
			int sip = num / 10;
			int ii = num % 10;
			
			if(sip == 3 || sip == 6 || sip == 9){
				count++;
				if(ii == 3 || ii == 6 || ii == 9){
					count++;
				}
			}else if (ii == 3 || ii == 6 || ii == 9){
				count++;
			}
			switch (count) {
			case 1:
				logger.debug("짝");
				break;
			case 2:
				logger.debug("짝짝");
			break;

		
			}
			
			
		}
		
		

	}

}
