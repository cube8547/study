package com.java.study.day4.domain;

public class Programmer extends Employee {

	public static final String C = "c";
	public static final String JAVA = "java";
	public static final String COBOL = "cobol";
	
	private LanguageType languageType;
	
	public Programmer(String name, int salary) {
		super(name, salary);
		languageType = LanguageType.JAVA;
	}

}
