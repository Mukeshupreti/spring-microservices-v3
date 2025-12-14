package com.globalsoftwaresupport;

public enum Database {

	// acquiring the INSTANCE is thread safe
    // enum are compile time constants
	INSTANCE;
	
	public void connect() {
		System.out.println("Connecting to the database...");
	}
	
	public void disconnect() {
		System.out.println("Disconnecting the database...");
	}
}
