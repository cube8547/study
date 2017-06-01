package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		String configLocation = "classpath:applicationCTX.xml";		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation); //스프링 컨테이너 생성
		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class); //getBean, myinfo 얻어옴, 스프링 컨테이너에서 컴포넌트 가져옴
		myInfo.getInfo();
		ctx.close();
		
	}
	
}
