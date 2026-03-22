package com.globalsoftwaresupport;

public class Addition implements Strategy {

	@Override
	public void execute(int num1, int num2) {
		System.out.println(num1 + num2);
	}
}
