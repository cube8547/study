package com.java.study.day4.domain;

public enum LanguageType {
	C("c"),
	JAVA("java"),
	COBOL("cobol");
	
	private String language;
	
	private LanguageType(String language) {
		this.language = language;
	}
}
