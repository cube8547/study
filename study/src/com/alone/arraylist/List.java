package com.alone.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/*
이번에는 자바 리스트 클래스들에 대해 알아 보겠습니다. 
리스트는 배열의 한계 때문에 만들어진 자료형 입니다. 
배열을 사용하기 위해서는 크기를 정해야 합니다. 
그런데 프로그래밍 중 크기를 알 수 없는 경우가 더 많죠. 
List 는 메모리가 허용하는 한 계속 해서 추가 할 수 있도록 만든 자료형 클래스 입니다.
*/


public class List {
	static Logger logger = Logger.getLogger(List.class);//클래스명 아래에 사용
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용	
		
		/*
		▼ java.util.List 는 인터페이스 클래스이며 java.util.Collection 인터페이스를 구현한 것입니다. 
		List 를 사용하기 위해서는 아래 클래스들중 하나로 인스턴스화 할수 있습니다.

		*/
		
		
/*		
		ArrayList listA = new ArrayList();
		LinkedList listB = new LinkedList();
		Vector listC = new Vector();
		Stack listD = new Stack();
		*/
		
		logger.debug("---------------------------------------------------");
		
/*		
		▼ 이번에는 값들을 추가하고 인덱스에 해당하는 값을 하나씩 가져오거나 모든 데이터를 꺼내는 방법입니다. 
		값을 추가하기 위해서 add() 함수를 사용합니다. 아래 그림처럼 텍스트값 3개를 추가했습니다. 
		그리고 제일 아래에 있는 add() 함수는 형태가 좀 틀리죠. 첫번째 인수로 요소값을 넣었습니다. 
		요소값을 넣고 데이터를 추가하게 되면 해당 요소에 값을 교체하는 것이 아니라 추가하고 데이터들이 하나씩 밀리게 됩니다. 
		아래 그림을 참고 하시기 바랍니다.
		*/
		

		ArrayList listA = new ArrayList();
		
		listA.add("김삿갓");
		listA.add("홍아리");
		listA.add(new String("홍길동"));
		
		listA.add(1,"1번째 요소값");
		
		logger.debug(listA);
		logger.debug("---------------------------------------------------");
		
		/*
		▼ 인덱스로 값을 조회하고 싶다면 get(index) 함수를 사용하면 됩니다. 
		하나씩 조회하고 싶을 때 사용하는 방법이고 모든 데이터를 전부 출력하고 싶다면 Iterator 와 For loop문을 이용합니다.
		List 클래스의 iterator() 함수로 Iterator 객체를 리턴받아 사용합니다. 
		*/
		
		//인덱스를 통한 조회
		String element0 = listA.get(0).toString();
		String element1 = listA.get(1).toString();
		String element2 = listA.get(2).toString();
		
		// Iterator 통한 전체 조회
		Iterator iterator = listA.iterator();
		while (iterator.hasNext()) {
			String element = (String) iterator.next();
			
		}
		//for-loop 통한 전체 조회
		for(Object object : listA) {
			String element = (String) object;
		}
		
		logger.debug("---------------------------------------------------");
		/*
		▼ 위에서 값을 추가할 때 add() 함수의 첫번째 인수로 인덱스를 넘기게 되면 해당 위치 앞에 값이 추가 된다고 했습니다. 
		위치를 알고 있을때는 지정하면 되는데 알수 없을때는 어떻게 할까요? 
		indexof() 함수를 이용해서 위치값을 찾은 뒤 add() 함수를 이용하시면 되겠죠.  		
		*/
		//홍길동 앞에 값추가
		int index = listA.indexOf("홍길동");
		listA.add(index, "홍길동 앞에 값 추가");
		
		logger.debug("---------------------------------------------------");
		/*
		 * ▼ 리스트안에 있는 데이터중 찾고자 하는 값이 존재하는지 확인할수 있는 함수가 contains 입니다. 
		 * 함수 인수로 오브젝트를 넘기게 되면 boolean 값을 리턴하게 됩니다. 아래 결과값은 true 가 되겠죠.
		*/
		//존재여부 확인
		logger.debug(listA.contains("홍길동"));
		
		logger.debug("---------------------------------------------------");
		
		
		/*
		▼ 객체를 삭제하는 방법은 두가지가 있습니다. 
		인덱스를 이용하는 방법과 동일한 오브젝트를 인수로 넘기면 검색해서 삭제시켜 줍니다. 
		오브젝트를 이용해서 삭제하게 되면 삭제 결과가 성공인지 실패인지만 알려주고 
		인덱스로 삭제하게 되면 어떤 데이터를 삭제했는지 리턴값으로 알려줍니다.
		*/
		
		
		//값 삭제하는 방법
		logger.debug(listA.remove(0));
		logger.debug(listA.remove("홍길동"));
		
		
		
		
		
		logger.debug("---------------------------------------------------");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}










