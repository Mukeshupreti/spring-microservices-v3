package com.globalsoftwaresupport;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle());
		// shapes.add(new Triangle());
		shapes.add(new Rectangle());
		
		Visitor save = new SaveCSVFile();
		
		for(Shape shape : shapes)
			shape.accept(save);
		
	}
}
