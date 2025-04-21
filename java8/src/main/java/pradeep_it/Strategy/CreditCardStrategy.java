package pradeep_it.Strategy;

public class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void payment(double amount) {
        System.out.println("CreditCardStrategy");
    }
}