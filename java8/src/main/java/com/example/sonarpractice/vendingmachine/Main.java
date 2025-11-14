package com.example.sonarpractice.vendingmachine;

import java.util.*;

public class Main {
    public static void main(String[] args){
        VendingMachine vm = new VendingMachine();
        vm.addProduct(new Product("Soda", 1.5), 5);
        vm.addProduct(new Product("Chips", 1.0), 3);
        System.out.println(vm.display());
        vm.insertCoin(1.0);
        vm.insertCoin(0.5);
        Optional<Product> p = vm.selectProduct("Soda");
        System.out.println("Dispensed: " + p.map(Product::getName).orElse("none"));
        System.out.println("Change returned: " + vm.returnChange());
    }
}

class Product {
    private final String name; private final double price;
    public Product(String name,double price){ this.name=name; this.price=price; }
    public String getName(){ return name; } public double getPrice(){ return price; }
    public String toString(){ return name+"("+price+")"; }
}

class VendingMachine {
    private final Map<String,Integer> stock = new HashMap<>();
    private final Map<String,Product> products = new HashMap<>();
    private double balance = 0.0;
    public void addProduct(Product p,int qty){ products.put(p.getName(), p); stock.put(p.getName(), stock.getOrDefault(p.getName(),0)+qty); }
    public String display(){
        StringBuilder sb=new StringBuilder();
        products.values().forEach(pr-> sb.append(pr).append(" qty=").append(stock.getOrDefault(pr.getName(),0)).append("\n"));
        return sb.toString();
    }
    public void insertCoin(double v){ balance += v; }
    public Optional<Product> selectProduct(String name){
        Product p = products.get(name);
        if(p==null) return Optional.empty();
        if(stock.getOrDefault(name,0)<=0) return Optional.empty();
        if(balance < p.getPrice()) return Optional.empty();
        stock.put(name, stock.get(name)-1);
        balance -= p.getPrice();
        return Optional.of(p);
    }
    public double returnChange(){ double c = Math.round(balance*100.0)/100.0; balance=0; return c; }
}
