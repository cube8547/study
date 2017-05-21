package com.alone.day;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
▼ 특정 날짜 두개에서 그 차이값을 알고 싶을 때 사용할수 있는 방법입니다. 
먼저 String 으로 되어 있는 날짜를 SimpleDateFormat 이용해서 Date 객체로 바꿉니다. 
Date 객체의 getTime() 은 시간을 long 값으로 계산해서 리턴해줍니다. 
2개의 long 값을 빼면 시간차가 나오는데 이것을 하루 단위로 바꾸기 위해 24(시간) * 60(분) * 60(초) * 1000(1000 분의 1) 곱한값을 나눕니다.


*/
public class DayGap {

	public static void main(String[] args) {
		
		// 두날짜의 차이 구하기
		public void doDiffOfDate(){
		    String start = "2015-04-01";
		    String end = "2015-05-05";
		     
		    try {
		        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		        Date beginDate = formatter.parse(start);
		        Date endDate = formatter.parse(end);
		         
		        // 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
		        long diff = endDate.getTime() - beginDate.getTime();
		        long diffDays = diff / (24 * 60 * 60 * 1000);
		 
		        System.out.println("날짜차이=" + diffDays);
		         
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		}

	}

}
