package com.alone.day;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;




/*
▼ 시간을 계산하기 위해 long 값으로 변환한 데이터를 다시 날짜 객체로 변환하기 위한 방법입니다. 
long 값을 Date 객체 생성할 때 인수로 넘기면 됩니다. 
그 이후에는 SimpleDateFormat 나 DateFormat 클래스를 이용해서 원하는 형태의 날짜 포맷으로 변경하시면 되겠죠.

*/


public class DateOfFormat {	

	public static void main(String[] args) {
		
		public void doLongDate() {
		    Date curret = new Date();
		    long ttl = curret.getTime();
		    System.out.println(ttl);
		 
		    Date today = new Date(ttl);
		    DateFormat fm = DateFormat.getDateInstance(DateFormat.FULL,
		            Locale.KOREA);
		    String str = fm.format(today);
		    System.out.println(str);
		 
		}
	}

}
