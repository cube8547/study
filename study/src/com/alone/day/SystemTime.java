package com.alone.day;



/*

▼ 시간의 차이를 알기 위해서는 시간을 long 값으로 변경해서 빼주면 됩니다. 
아래 예제는 시스템의 시간을 알아와서 그 차이 값을 계산하는 소스 입니다. 
보통 소스의 실행 시간을 계산할 때 많이 쓰죠. 시간의 차이값을 계산할려면 long 값으로 바꾼후 빼면 됩니다. 
시스템의 시간을 long 값으로 알아올수 있는 함수가  System.currentTimeMillis() 입니다.

*/



public class SystemTime {

	public static void main(String[] args) {
		
		
		// 시스템 경과 시간 구하기
		public void doDiffSystem(){
		    try {
		        long time1 = System.currentTimeMillis();
		         
		        Thread.sleep(1500);// 1.5 초 경과
		                 
		        long time2 = System.currentTimeMillis();
		         
		        System.out.println((time2 - time1 ) / 1000.0 );
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}


		
	}

}
