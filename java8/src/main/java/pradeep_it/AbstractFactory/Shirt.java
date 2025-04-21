package pradeep_it.AbstractFactory;

// Concrete Product
public class Shirt extends ClothingProduct {
    @Override
    public void displayProduct() {
        System.out.println("Shirt - Fashion Category");
    }
}

