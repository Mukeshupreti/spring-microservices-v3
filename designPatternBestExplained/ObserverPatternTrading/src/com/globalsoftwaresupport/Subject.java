package com.globalsoftwaresupport;

public interface Subject {
	public void addObserver(Observer o);
	public void notifyAllObserver();
}
