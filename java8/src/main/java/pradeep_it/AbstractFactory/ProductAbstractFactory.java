package pradeep_it.AbstractFactory;

//This will hide the factory Implemetation and return Factory created object
public abstract class ProductAbstractFactory {
    public abstract Product createElectronicProduct();
    public abstract Product createClothingProduct();
}
