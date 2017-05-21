package com.alone.day;

import java.util.Calendar;
import java.util.TimeZone;



/*
▼ 타임존을 설정하게 되면 해당 지역의 시각을 얻어 올수 있습니다. 
TimeZone 의 getTimeZone() 함수에 해당지역의 ID 값을 넘기면 됩니다. 
현재 사용가능한 타임존을 알고 싶다면 TimeZone 의 getAvailableIDs() 함수를 이용해서 데이터를 받아 보시면 됩니다. 

*/
public class WorldTime {

	public static void main(String[] args) {
		public void doTimeZone(){
		    // 각국 주요 도시의 현재 시각을 얻을수 있습니다.
		    TimeZone jst = TimeZone.getTimeZone("Asia/Seoul");
		    Calendar cal = Calendar.getInstance(jst);
		    System.out.println ( cal.get ( Calendar.YEAR ) + "년 "
		                        + ( cal.get ( Calendar.MONTH ) + 1 ) + "월 "
		                        + cal.get ( Calendar.DATE ) + "일 "
		                        + cal.get ( Calendar.HOUR_OF_DAY ) + "시 "
		                        + cal.get ( Calendar.MINUTE ) + "분 "
		                        + cal.get ( Calendar.SECOND ) + "초 "
		                        );
		}



	}

}
