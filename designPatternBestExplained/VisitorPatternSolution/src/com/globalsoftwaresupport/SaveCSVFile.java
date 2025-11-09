package com.globalsoftwaresupport;

public class SaveCSVFile implements Visitor {

	@Override
	public void visitCircle(Circle circle) {
		System.out.println("Saving the circle...");
	}

	@Override
	public void visitTriangle(Triangle triangle) {
		System.out.println("Saving the triangle...");
	}

	@Override
	public void visitRectangle(Rectangle rectangle) {
		System.out.println("Saving the rectangle...");
	}
}
