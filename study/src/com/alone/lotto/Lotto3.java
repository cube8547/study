package com.alone.lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



//3. 중복 제거를 위해 Set 컬렉션 사용

/*
중복을 방지하기 위해서 다음과 같이 함수를 lottoNumbers() 함수를 수정하였습니다. 
Set 컬렉션 클래스를 사용하시면 됩니다. Set 에서 Add 함수로 값을 추가할 때 중복된 데이터는 들어가지 않습니다. 
그러니까 Set 컬렉션의 전체 개수가 6이 될 때 까지 While 문을 이용해 계속 반복시키는 것이죠.  

*/
public class Lotto3 {
	static Logger logger = Logger.getLogger(Lotto2.class);//클래스명 아래에 사용
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용	
		
		Lotto3 lotto = new Lotto3();
		Scanner sc = new Scanner(System.in);
		
		logger.debug("로또번호 추출 수 입력");
		
		int gameCnt = sc.nextInt();
		
		for (int i = 1; i <= gameCnt; i++) {
			logger.debug(i + "번째 로또 번호 : " + lotto.lottoNumbers());
		}

	}
	
	String lottoNumbers() {
		Set<Integer> set = new HashSet<Integer>();
		while(set.size() < 6){
			Double d = Math.random() * 45 + 1;
			set.add(d.intValue());
		}
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		
		return list.toString();
	}

}
