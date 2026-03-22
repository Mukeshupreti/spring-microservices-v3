
package com.example.cqrs.query.dto;

import java.io.Serializable;

public class OrderViewDTO implements Serializable {

    private Long id;
    private String product;
    private int quantity;

    public Long getId() { return id; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public void setId(Long id) { this.id = id; }
    public void setProduct(String product) { this.product = product; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "OrderViewDTO{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
