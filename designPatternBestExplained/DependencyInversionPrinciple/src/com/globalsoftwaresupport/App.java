package com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		DatabaseController controller = new DatabaseController(new OracleDatabase());
		controller.connect();
		controller.disconnect();
		
	}
}
