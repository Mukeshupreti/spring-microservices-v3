package com.example.sonarpractice.payments;

public class Main {
    public static void main(String[] args){
        PaymentProcessor proc = new PaymentProcessor();
        proc.process(new CreditCardPayment("1111-2222-3333-4444"), 50.0);
        proc.process(new PayPalPayment("user@paypal"), 12.5);
        proc.process(new UPIPayment("upi@bank"), 7.25);
    }
}

interface PaymentMethod { void pay(double amount); }

class CreditCardPayment implements PaymentMethod {
    private final String card;
    public CreditCardPayment(String card){ this.card=card; }
    public void pay(double amount){ System.out.println("Paid " + amount + " via CreditCard " + card); }
}

class PayPalPayment implements PaymentMethod {
    private final String account;
    public PayPalPayment(String acc){ this.account=acc; }
    public void pay(double amount){ System.out.println("Paid " + amount + " via PayPal " + account); }
}

class UPIPayment implements PaymentMethod {
    private final String upi;
    public UPIPayment(String upi){ this.upi=upi; }
    public void pay(double amount){ System.out.println("Paid " + amount + " via UPI " + upi); }
}

class PaymentProcessor {
    public void process(PaymentMethod m, double amount){ m.pay(amount); }
}
