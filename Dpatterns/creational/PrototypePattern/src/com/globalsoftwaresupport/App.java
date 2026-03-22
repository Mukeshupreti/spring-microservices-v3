package com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		Shape square = new Square(10, 5);
		square.draw();
		
		Shape squareClone = square.cloneObject();
        // now we have a clone of the original object
        // you can modify it independently if needed
		squareClone.draw();
	}
}
