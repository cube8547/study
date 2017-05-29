package com.java.study.day4.domain;

/**
 * 열거형 Gender
 */
public enum Gender {

	MALE("남자", 1),
	FEMALE("여자", 2);
	
	private String value;
	private int code;
	
	// default : private
	Gender(String value, int code){
		this.value = value;
		this.code = code;
	}
}
