package com.alone.beginning;

import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class WorldTimeId {
	static Logger logger = Logger.getLogger(WorldTimeId.class);//클래스명 아래에 사용
	
	/*
	 * ▼ 이외 사용가능한 타임존 아이디 값이 어떤것들이 있는지 알려면 어떻게 할까요? 
	 * TimeZone.getAvailableIDs() 함수를 이용하면 모든 이용가능한 타임존 아이디를 가져옵니다. 
	*/

	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용	
		
		 String[] local = TimeZone.getAvailableIDs();
	        for (int i = 0; i < local.length; i++) {
	            logger.debug(local[i]);
	        }



	}

}
