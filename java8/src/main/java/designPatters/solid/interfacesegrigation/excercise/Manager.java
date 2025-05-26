package designPatters.solid.interfacesegrigation.excercise;

public class Manager implements IManager {

	@Override
	public void salary() {
		System.out.println("Getting the salary...");
	}

	@Override
	public void hire() {
		System.out.println("Hiring new employees...");
	}

	@Override
	public void train() {
		System.out.println("Training the employees...");
	}

	@Override
	public void addBonus() {
		System.out.println("Adding bonus at the end of the year...");
	}
}
