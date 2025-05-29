package designPatters.creational.abscractFactory.code.simpleImpl;

public class FactoryProducer {

	public static AbstractFactory getFactory(String factory) {
		
		if(factory.equals("ELECTRIC"))
			return new ElectricCarFactory();
		else if(factory.equals("PETROL"))
			return new PetrolCarFactory();
		
		return null;
	}
}
