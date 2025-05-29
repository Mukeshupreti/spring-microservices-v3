package designPatters.creational.prototype.code;

public class Square extends Shape {

	public Square(int width, int height) {
		super(width, height);
	}

	@Override
	public void draw() {
		System.out.println("Square with width: " + width + " height: " + height);
	}

	@Override
	public Shape cloneObject() {
		// this is the prototype pattern
		return new Square(width, height);
	}	
}
