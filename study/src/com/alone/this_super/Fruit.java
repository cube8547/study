package com.alone.this_super;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.alone.beginning.WorldTime;



/*
this 현재 클래스의 인스턴스를 가리킵니다. 
super 는 부모 클래스를 가리킵니다. 
현재 클래스의 인스턴스에 있는 속성이나 함수를 제어하려면 this.setName() 을 하고 
부모 클래스의 함수를 호출하고 싶으면 super.setName() 을 입력합니다. 
아래 소스를 보면서 어떻게 사용하는지 알아 보도록 하겠습니다.
*/
public class Fruit {
	static Logger logger = Logger.getLogger(WorldTime.class);//클래스명 아래에 사용
	
	public String name;
	public String color;
	public double weight;
	
	public Fruit(String name, String color, double weight) {   
		
		/*name = name;
		color = color;
		weight = weight;*/
		
		
		// 아래처럼 this를 붙여준다
		
		this.name = name;
		this.color = color;
		this.weight = weight;
		
	}
	
	// Exe에서 Fruit로 자신의 참조값을 전달하고 싶을 때
	/*
	 * ▼ 어떤 함수에서는 리턴값으로 자기 자신의 참조값을 전달하고 싶을 때가 있습니다. 이 때 this 키워드를 이용함으로써 해결이 가능합니다.
	*/
	
	public Fruit getInstance() {
        return this;
    }
	
	
	/*
	클래스의 속성과 매개변수의 이름이 같을 때
	 
	▼ 아래 소스는 this 를 사용하지 않았을 때 상황입니다. 
	주로 set/get 함수를 만들 때 실수하는 경우 입니다. 
	매개 변수의 이름과 Fruit 에 내에 지역변수 이름이 같기 때문에 Fruit 객체의 name 속성에 값이 저장되지 않습니다. 
	이 때 Fruit 인스턴스를 가리키는 this 키워드를 사용해야 되는 것입니다.			
	*/
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("properties/log4j.properties");//메인 메소드 아래 사용	


		Fruit banana = new Fruit("banana", "yellow", 5.0);
		logger.debug("name : " + banana.name);
		logger.debug("color : " + banana.color);
		logger.debug("weight : " + banana.weight);
		
		logger.debug("------------------------------------------------");
		
		
	}

}
