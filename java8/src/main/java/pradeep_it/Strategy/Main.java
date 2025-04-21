package pradeep_it.Strategy;

/*
Demonstrate code example for Strategy pattern for payment method, where I have Credit card, Net Banking, Debit Card, UPI payment-Done
*/

public class Main {

    public static void main(String[] args) {
        PaymentSystem paymentSystem1 = new PaymentSystem(new CreditCardStrategy());
        paymentSystem1.doPayment(2.0);

        PaymentSystem paymentSystem2 = new PaymentSystem(new UPIStrategy());
        paymentSystem2.doPayment(2.0);

        PaymentSystem paymentSystem3 = new PaymentSystem(new DebitCardStrategy());
        paymentSystem3.doPayment(2.0);


    }
}
