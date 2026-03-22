
package com.example.cqrs.command.dto;

public class CreateOrderCommandDTO {

    private String product;
    private int quantity;

    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public void setProduct(String product) { this.product = product; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
