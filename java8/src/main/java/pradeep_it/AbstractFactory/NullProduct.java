package pradeep_it.AbstractFactory;

public class NullProduct implements Product {
    @Override
    public void displayProduct() {
        System.out.println("Invalid product category");
    }
}
