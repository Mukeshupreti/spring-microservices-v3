
package com.example.cqrs.event;

public class OrderCreatedEvent {

    private Long orderId;
    private String product;
    private int quantity;

    public OrderCreatedEvent() {}

    public OrderCreatedEvent(Long orderId, String product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getOrderId() { return orderId; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public void setProduct(String product) { this.product = product; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
