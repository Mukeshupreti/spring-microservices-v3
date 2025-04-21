package pradeep_it.abstractfactory;

// This will hide the factory Implemetation and return Factory created object

public abstract class DaoAbstractFactory {

	public abstract Dao createDao(String type);
}
