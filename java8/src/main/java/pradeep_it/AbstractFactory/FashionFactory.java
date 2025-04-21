package pradeep_it.AbstractFactory;

// Concrete Factory
public class FashionFactory extends ProductAbstractFactory {
    @Override
    public Product   createElectronicProduct() {
        return new NullProduct();
    }

    @Override
    public Product createClothingProduct() {
        return new Shirt();
    }
}