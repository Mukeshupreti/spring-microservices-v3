package com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		Database o1 = Database.INSTANCE;
		Database o2 = Database.INSTANCE;
		
		if(o1==o2)
			System.out.println("The objects are the same...");
	}
}
