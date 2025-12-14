package com.globalsoftwaresupport;

public class OperationManagerBAD {

	public void execute(Object o, int num1, int num2) {
		
		// test this branch of the app
		if( o instanceof Addition)
			((Addition) o).execute(num1, num2);
		// this branch as well
		else if(o instanceof Multiplication)
			((Multiplication) o).execute(num1, num2);
	}
}
