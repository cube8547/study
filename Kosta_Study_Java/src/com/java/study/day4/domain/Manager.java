package com.java.study.day4.domain;

/**
 * Employee를 상속하는 Manager 클래스
 * Manager 클래스가 extends를 통해 Employee를 상속 받는다
 */
public class Manager extends Employee {

	private double bonus;
	
	public Manager(String name, int salary, double bonus) {
		super(name, salary);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	/**
	 * 상위 객체 오버라이딩
	 * @Override : annotation
	 */
	@Override
	public int getSalary() {
		return super.getSalary() + (int) bonus;
	}
}
