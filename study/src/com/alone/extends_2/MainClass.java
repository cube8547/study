package com.alone.extends_2;

public class MainClass {
	
	public static void main(String[] args) {
		
		ChildClass childClass = new ChildClass();
		childClass.method1(); //자식 클래스에 있는 메소드1 실행
		childClass.method2(); // 부모 클래스에 있는 메소드2 실행
		
	}
	
}
