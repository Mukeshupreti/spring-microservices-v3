package designPatters.solid.liskovesubsitution.principal;

public class ElectricCar extends Vehicle {

	public ElectricCar(String type, int age) {
		super(type, age);
	}

	@Override
	protected void speedUp() {
		System.out.println("Electric car is speeding up...");
	}
	
	@Override
	protected void slowDown() {
		System.out.println("Electric car is slowing down...");
	}
	/// If you throgh expceoption here that meaning you are braking the change or Subclass
    /// is not replaaeable with super class. Make is method abstract so that it can be override by
    /// subclaas to do it own thing in its own way
	@Override
	public void fuel() {
		System.out.println("Electric car is being charged...");
	}
}
