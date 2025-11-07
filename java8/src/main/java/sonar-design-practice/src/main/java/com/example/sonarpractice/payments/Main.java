package com.example.sonarpractice.payments;
public class Main {
    public static void main(String[] args) {
        PaymentProcessor p = new PaymentProcessor();
        p.process(new CreditCardPayment(), 100.0);
    }
}
interface PaymentMethod { void pay(double amount); }
class CreditCardPayment implements PaymentMethod {
    public void pay(double amount){ System.out.println("Paid " + amount + " via CreditCard"); }
}
class PaymentProcessor {
    public void process(PaymentMethod m, double amount){ m.pay(amount); }
}
