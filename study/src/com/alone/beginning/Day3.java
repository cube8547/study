package com.alone.beginning;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Day3 {
	
	/* 2차원 평면에서 하나의 직사각형은 두 점으로 표현된다. (50, 50) 과 (100, 100) 의 두 점으로 이루어진 사각형이 있다고 하자. 
	이 때 키보드로부터 한 점을 구성하는 X와 Y를 입력받고 점 (X, Y)가 사각형 안에 있는지를 판별하는 프로그램 */

	static Logger logger = Logger.getLogger(Day3.class);//클래스명 아래에 사용
	public static void main(String[] args) {
	
	PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용			

	Scanner sc = new Scanner(System.in);
	logger.debug("공백으로 구분하여 두 정수를 입력 하시오");
	
	int x = 50;
	int y = 100;
	
	int sc_x = sc.nextInt();
	int sc_y = sc.nextInt();
	
	if(sc_x >= x && sc_x <= y){
		if(sc_y >= x && sc_y <= y){
		logger.debug("사각형 안에 있습니다.");
	}else{
		logger.debug("사각형 밖에 있습니다.");
	}
	
	}else{
		logger.debug("사각형 밖에 있습니다.");
		
	}
	
}
}
