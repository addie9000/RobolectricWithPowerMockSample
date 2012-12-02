package com.example.robolectrictest;

public class ClassForTest {
	private String uselessString = "useless!!";
	
	public static ClassForTest getInstance() {
		return new ClassForTest();
	}
	public String getString() {
		return uselessString;
	}

}
