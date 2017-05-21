package com.alone.day;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/*
▼ 지정한 날짜에서 시간을 더할 때 GregorianCalendar 클래스를 사용합니다. 
add() 함수가 날짜에 대한 사칙연산을 하게 되는데 첫번째 인수로 연산하고 싶은 날짜 필드를 넘기시면 됩니다. 
두번째 필드는 더하고 싶은 값을 넘기면 되는데 마이너스 값이면 시간을 빼게 됩니다.

*/
public class DayPlus {

	public static void main(String[] args) {
		// 년도, 월, 일 더하기
		public void doDateAdd(){
		    Calendar cal = new GregorianCalendar(Locale.KOREA);
		    cal.setTime(new Date());
		    cal.add(Calendar.YEAR, 1); // 1년을 더한다.
		    cal.add(Calendar.MONTH, 1); // 한달을 더한다.
		    cal.add(Calendar.DAY_OF_YEAR, 1); // 하루를 더한다.
		    cal.add(Calendar.HOUR, 1); // 시간을 더한다
		     
		    SimpleDateFormat fm = new SimpleDateFormat(
		            "yyyy-MM-dd HH시mm분ss초");
		    String strDate = fm.format(cal.getTime());
		    System.out.println(strDate);
		}


	

	}

}
