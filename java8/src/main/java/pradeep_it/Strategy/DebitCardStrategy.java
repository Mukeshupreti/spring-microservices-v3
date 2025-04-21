package pradeep_it.Strategy;

public class DebitCardStrategy implements PaymentStrategy {
    @Override
    public void payment(double amount) {
        System.out.println("DebitCard");
    }
}
