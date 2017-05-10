package com.alone.beginning;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.alone.arraylist.List;

/*
프로그램을 하다보면 국내용이 아닌 전 세계를 상대로 시간을 계산해야 될때가 있습니다. 
그러면 현지의 시간을 알아 오는 방법을 찾아야 겠죠. 자바에서는 TimeZone 클래스가 그 역할을 하고 있습니다. 
*/
public class WorldTime {
	static Logger logger = Logger.getLogger(WorldTime.class);//클래스명 아래에 사용
	
	/*
	▼ TimeZone 의 getTimeZone() 함수로 각국의 타임존 아이디를 인수로 넘기면 객체를 만들수 있습니다. 
	이렇게 만들어진 TimeZone 객체를 DateFormat 의 형태에 맞추기위해 setTimeZone() 에 셋팅합니다.
	*/
	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용	
		
		TimeZone time;
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss (z Z)");
		
		time = TimeZone.getTimeZone("Asia/Seoul");
		df.setTimeZone(time);
		//logger.debug("%s%n%s%n%n", time.getDisplayName(), df.format(date));
		System.out.format("%s%n%s%n%n", time.getDisplayName(), df.format(date));
		
		time = TimeZone.getTimeZone("JST");
		df.setTimeZone(time);
	//	logger.debug("%s%n%s%n%n", time.getDisplayName(), df.format(date));
		System.out.format("%s%n%s%n%n", time.getDisplayName(), df.format(date));
		
		time = TimeZone.getTimeZone("America/Los_Angeles");
		df.setTimeZone(time);
	//	logger.debug("%s%n%s%n%n", time.getDisplayName(), df.format(date));
		System.out.format("%s%n%s%n%n", time.getDisplayName(), df.format(date));
		
		time = TimeZone.getTimeZone("America/New_York");
		df.setTimeZone(time);
	//	logger.debug("%s%n%s%n%n", time.getDisplayName(), df.format(date));
		System.out.format("%s%n%s%n%n", time.getDisplayName(), df.format(date));
		
		time = TimeZone.getTimeZone("Pacific/Honolulu");
		df.setTimeZone(time);
	//	logger.debug("%s%n%s%n%n", time.getDisplayName(), df.format(date));
		
		System.out.format("%s%n%s%n%n", time.getDisplayName(), df.format(date));
		
		

	}

}
