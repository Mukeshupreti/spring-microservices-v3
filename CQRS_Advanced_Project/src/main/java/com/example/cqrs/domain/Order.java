
package com.example.cqrs.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String product;
    private int quantity;
    private String status;

    public Long getId() { return id; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public String getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setProduct(String product) { this.product = product; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setStatus(String status) { this.status = status; }
}
