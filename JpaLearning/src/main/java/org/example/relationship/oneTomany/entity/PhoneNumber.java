package org.example.relationship.oneTomany.entity;

import jakarta.persistence.*;

@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String type;
    /*
    create table phone_number(
                             id int PRIMARY KEY AUTO_INCREMENT,
                             customer_id int,
                             number varchar(20),
                             type varchar(20),
                             FOREIGN KEY (customer_id)
                                 REFERENCES customer(id))
     */
    @ManyToOne
    @JoinColumn(name = "customer_id") // customer_id is foreign key ,
    //JoinColumn(name = "customer_id" ,referencedColumnName = "id") both line is same
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
