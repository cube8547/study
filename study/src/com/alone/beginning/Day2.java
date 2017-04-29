package com.alone.beginning;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



/* 대문자 < - > 소문자 변환하기
 * 
 * 스캐너 클래스를 이용하여 키보드에서 영문자 한자를 입력받아 소문자로 변환하고, 소문자를 입력하면 대문자로 변환하는 프로그램을 작성하세요. 
대문자와 소문자가 아니면 "영문자가 아닙니다"를 출력하게 하세요*/




public class Day2 {
	static Logger logger = Logger.getLogger(Day2.class);//클래스명 아래에 사용
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용		
		
		Scanner sc = new Scanner(System.in);
		logger.debug("알파벳을 입력하세요");
		
		char ch = sc.next().charAt(0); //0번째에 있는 글자 반환
		
		if(ch >= 'A' && ch <= 'Z'){ //대문자
			logger.debug((char)(ch+('a'-'A'))); // ch+, 'a'-해야 대문자에서 소문자로 변환
		}else if (ch >= 'a' && ch <= 'z'){ //소문자
			logger.debug((char)(ch-('a'-'A'))); // ch-, 'a'- 해야 소문자에서 대문자로 변환    +, - 제대로 사용 안하면 다른 아스키 값이 나옴
		}else{
			logger.debug("영문자가 아닙니다.");
		}
		
		
		
		
		
		
		
		
		/*Scanner sc = new Scanner(System.in);
		logger.debug("알파벳을 입력해주세요");
		
		char ch = sc.next().charAt(0); //맨 앞글자 반환해주는 함수 (숫자로 자리수)
		
		//System.out.println(ch);
		
		if(ch >= 'A' && ch <= 'Z'){ //대문자
			logger.debug((char)(ch+('a'-'A')));
			}else if (ch >= 'a' && ch <= 'z'){ //소문자
				logger.debug((char)(ch-('a'-'A')));
			}else{
				logger.debug("영문자가 아닙니다.");
			}*/
		
	}

}
