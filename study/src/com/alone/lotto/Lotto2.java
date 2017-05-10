package com.alone.lotto;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;




//2. Math.random() 을 이용해서 로또번호 추출

public class Lotto2 {
	static Logger logger = Logger.getLogger(Lotto2.class);//클래스명 아래에 사용
	
	/*
	▼ 이번에는 Math.random() 함수를 이용하였습니다. 
	내용을 보시면 Collections.shuffle() 이용한 것보다 좀더 심플하죠. 
	Math.random() 함수에서 0.0 ~ 1.0 사이의 소수점 double 값을 리턴하게 되는데 45 를 곱하고 1을 더하게 되면 1~45 값중 하나가 되는 것입니다. 
	이렇게 추출한 값을 int 배열에 넣고 Arrays.sort() 함수로 순서를 정렬합니다.
	*/
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용	
		
		Lotto2 lotto = new Lotto2();
		
		Scanner sc = new Scanner(System.in);
		
		logger.debug("로또 번호 추출 수 입력");
		int gameCnt = sc.nextInt();
		
		for(int i = 1; i <= gameCnt; i++) {
			logger.debug(i + "번째 로또번호 : " + lotto.lottoNumbers());
		}	}
	
	String lottoNumbers() {
		
		int[] lottoNums = new int[6];
		for(int i=0; i<=5; i++){
            lottoNums[i] = (int) (Math.random()*45+1);
        }
         
        // 정렬
        Arrays.sort(lottoNums);
 
        return Arrays.toString(lottoNums);
    }
}
 



