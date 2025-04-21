package pradeep_it.Strategy;

public class PaymentSystem {

    PaymentStrategy paymentStrategy;

    PaymentSystem(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }

    public  void doPayment(Double amount){
        paymentStrategy.payment(amount);
    }
}
