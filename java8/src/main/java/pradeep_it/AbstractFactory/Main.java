package pradeep_it.AbstractFactory;
/*Demonstrate code example for Abstract factory for Products catagorization in E-commerce industries-Done*/
public class Main {

    public static void main(String[] args) {
        // Create a HomeApplianceFactory
        ProductAbstractFactory homeApplianceFactory = new HomeApplianceFactory();
        Product electronicProduct1 = homeApplianceFactory.createElectronicProduct();
        Product clothingProduct1 = homeApplianceFactory.createClothingProduct();

        electronicProduct1.displayProduct();
        clothingProduct1.displayProduct();

        // Create a FashionFactory
        ProductAbstractFactory fashionFactory = new FashionFactory();
        Product electronicProduct2 = fashionFactory.createElectronicProduct();
        Product clothingProduct2 = fashionFactory.createClothingProduct();

        electronicProduct2.displayProduct();
        clothingProduct2.displayProduct();
    }
}
