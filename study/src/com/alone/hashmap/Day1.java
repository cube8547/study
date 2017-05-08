package com.alone.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/*
HashMap 은 Map 인터페이스를 구현한 함수입니다. Map 이 가지고 있는 모든 함수들을 사용할 수가 있죠. 
데이터의 저장은 key, value 형태가 됩니다. 그리고 해싱(Hashing) 검색을 사용하기 때문에 대용량 데이터 관리에도 좋은 성능을 보여주고 있습니다. 
key 값은 중복이 되지 않고 value 값은 허용이 됩니다.

▼ HashMap 에서 데이터를 집어 넣는 방법은 put() 함수를 사용합니다. 
첫번째 인수로 key 값을 넣고 두번째 인수로 value 를 입력합니다. 
key 값에 integer가 아닌 소수점이 있는 실수를 사용하면 에러가 납니다.





*/


public class Day1 {
	static Logger logger = Logger.getLogger(Day1.class);//클래스명 아래에 사용

	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용		
		
		/* ▼ HashMap 에서 값을 가져오는 방법입니다. 저장할때 key 값을 저장하기 때문에 get() 함수의 인수로 찾고 싶은 key 값을 넘기시면 됩니다.
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "감자");
		map.put(2, "고구마");
		map.put(3, "마늘");
		
		//logger.debug(map); //map에 저장된 모든 값을 출력
		String val = map.get(3).toString(); //map의 3번키  값을 출력 준비 작업
		
		logger.debug("key 값이 3 데이터 : " + val); // map의 3번째 값을 출력
*/		

		
		/*
		▼ HashMap 은 iterator() 함수로 Iterator 객체를 리턴합니다.
 		Iterator 객체는 반복문 으로 데이터를 처리할 때 아주 유용합니다. 
 		Iterator 에 공통적으로 가지고 있는 hasNext() 함수로 null 인지 판단해서 while 문으로 반복합니다. 
 		그리고 차례대로 데이터를 가져올수 있는 next() 함수로 값을 꺼내죠. 이렇게 next() 로 꺼낸 값은 value 가 아니라 key 값입니다. 
 		key 값에 해당하는 value 를 가져올려면 다시 get() 함수를 사용해야 겠죠.
		*/
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "감자");
		map.put(2, "고구마");
		map.put(3, "마늘");
		
		Iterator<Integer> keySetIterator = map.keySet().iterator();
		while (keySetIterator.hasNext()) {
			Integer key = keySetIterator.next();
			logger.debug("key: " + key + " value: " + map.get(key)); // map의 3번째 값을 출력
		}
		
		/*
		▼ 다음은 HashMap 객체에 데이터를 한번에 지우는 함수 입니다. 
		clear() 함수는 저장된 모든 데이터를 지우며 null 포인트를 만드는 것은 아닙니다. 
		이렇게 지우고 나서 데이터가 있는지 체크해 볼수 있는 함수가 isEmpty() 입니다. clear() 로 지웠으니까 결과는 true 가 되겠죠.


		*/
		
		
		
	}

}
