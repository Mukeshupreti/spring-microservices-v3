package pradeep_it.Strategy;

public class UPIStrategy implements PaymentStrategy {
    @Override
    public void payment(double amount) {
        System.out.println("UPIStrategy");
    }
}
