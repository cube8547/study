package com.alone.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Lotto {
	static Logger logger = Logger.getLogger(Lotto.class);//클래스명 아래에 사용
	
	//1. Collections.shuffle() 이용한 로또 번호 추출하기
	
	
	/*
▼ 프로그램의 진행은 로또 번호를 몇 개 뽑아낼 것인지 묻습니다. 그러면 입력한 숫자 만큼 번호를 추출하게 됩니다. 
for 문을 이용해서 List 객체에 번호들을 모두 추가합니다. 
추가후 Collections.shuffle() 함수의 인수로 넘기게 되면 자동으로 섞어줍니다. 
그럼 리스트 안에는 섞은 값이 차례대로 추가 되어 있을 겁니다. 이것을 하나씩 꺼내시면 되겠죠. 
이렇게 꺼낸 값을 숫자의 숫서대로 정렬하기 위해 Array.sort() 함수를 이용했습니다.

*/	
	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용		
		
		Lotto lotto = new Lotto(); 
		
		Scanner sc = new Scanner(System.in);
		
		logger.debug("로또번호 추출 수 입력");
		int gameCnt = sc.nextInt();
		
		for (int i = 1; i <= gameCnt; i++) {
			logger.debug(i + "번째 로또번호 " + lotto.lottoNumbers());
		}

	}
	
	//List안에 로또 번호 추가
	
	String lottoNumbers() {
		List<Integer> lottoNum = new ArrayList<Integer>();	

	for(int i = 1; i <= 45; i++){
		lottoNum.add(i);
	}
	
	//set안의 수를 무작위로 섞는다
	Collections.shuffle(lottoNum);
	
	//lottoNum의 i를 get으로 뽑아서 lottoNums의 i값에 적용
	//6개의 공간을 만들고 만들어진 숫자를 넣는다 
	int[] lottoNums = new int[6];
	for(int i = 0; i < 6; i++){
		lottoNums[i] = lottoNum.get(i);
	}
	
	//정렬
	
	Arrays.sort(lottoNums);
	
	return Arrays.toString(lottoNums);
	
	
		
	
	}



}
