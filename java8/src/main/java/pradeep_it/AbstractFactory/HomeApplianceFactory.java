package pradeep_it.AbstractFactory;

public class HomeApplianceFactory extends ProductAbstractFactory {
    @Override
    public Product createElectronicProduct() {
        return new Television();
    }

    @Override
    public Product createClothingProduct() {
      return  new NullProduct();
    }
}

