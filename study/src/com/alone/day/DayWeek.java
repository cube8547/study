package com.alone.day;

import java.util.Calendar;







/*
▼ 날짜의 요일값을 알아오기 위해 Calendar 의 get() 함수를 이용하였습니다. 
인수로 Calendar.DAY_OF_WEEK 를 넘기게 되면 1과 7 사이의 값중에 하나를 리턴하게 됩니다. 
1이 일요일이고 7이 토요일이 되는 것이죠.

*/
public class DayWeek {

	public static void main(String[] args) {
		// 해당하는 요일 구하기
		public void doYo(){
		    Calendar cal= Calendar.getInstance();
		    String strWeek = null;
		     
		    int nWeek = cal.get ( Calendar.DAY_OF_WEEK );
		    if ( nWeek == 1 ) strWeek="일요일";
		    else if ( nWeek == 2 ) strWeek="월요일";
		    else if ( nWeek == 3 ) strWeek="화요일";
		    else if ( nWeek == 4 ) strWeek="수요일";
		    else if ( nWeek == 5 ) strWeek="목요일";
		    else if ( nWeek == 6 ) strWeek="금요일";
		    else if ( nWeek == 7 ) strWeek="토요일";
		     
		    System.out.println("현재요일 = " + strWeek);
		}



	}

}
