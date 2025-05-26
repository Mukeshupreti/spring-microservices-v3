package designPatters.solid.liskovesubsitution.principal;

public abstract class Vehicle implements Fuel {

	protected String type;
	protected int age;
	
	public Vehicle(String type, int age) {
		this.type = type;
		this.age = age;
	}
	
	protected void speedUp() {
		System.out.println("Vehicle is speeding up...");
	}
	
	protected void slowDown() {
		System.out.println("Vehicle is slowing down...");
	}
}
