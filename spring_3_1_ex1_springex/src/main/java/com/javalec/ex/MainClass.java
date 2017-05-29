package com.javalec.ex;

public class MainClass {

	public static void main(String[] args) {
		//MyCalculator 직접 생성 좋은 방법이 아님
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setCalculator(new Calculator());
		
		myCalculator.setFirstNum(10);
		myCalculator.setSecondNum(2);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		
	}
	
}
