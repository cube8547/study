package com.alone.day;



/*
▼ 다음 함수는 현재 날짜 구하는 방법입니다.
GregorianCalendar, SimpleDateFormat, Date 클래스로 원하는 포맷에 맞게 구할수 있습니다. 
Calendar 에서는 get() 함수에 현재 날짜의 원하는 값을 구하기 위한 필드값만 맞춰주면 됩니다. 
그중에 월을 구하는 Calendar.MONTH 에는 +1 을 해줘야 합니다. 0 부터 시작하기 때문입니다.	
*/

public class Day {

	public static void main(String[] args) {
		
		// 현재날짜 구하기
				public void doCurrentDate(){
				    int nYear;
				    int nMonth;
				    int nDay;
				     
				    // 현재 날짜 구하기
				    Calendar calendar = new GregorianCalendar(Locale.KOREA);
				    nYear = calendar.get(Calendar.YEAR);
				    nMonth = calendar.get(Calendar.MONTH) + 1;
				    nDay = calendar.get(Calendar.DAY_OF_MONTH);
				    System.out.println("GregorianCalendar = " + nYear + "-"
				            + nMonth + "-" + nDay);
				     
				    // Date 로 구하기
				    SimpleDateFormat fm1 = new SimpleDateFormat("yyyy년MM월dd일");
				    String date = fm1.format(new Date());
				    System.out.println("현재시간 년월일 = " + date);
				 
				    SimpleDateFormat fm2= new SimpleDateFormat(
				            "yyyy년MM월dd일HH시mm분ss초");
				    String date1 = fm2.format(new Date());
				    System.out.println("현재시간 시분초 = " + date1);
				}

	}

}
