package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"restaurant"})
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private int stock;

    private double price;

    @ManyToOne
    private Restaurant restaurant;

    public Product(String name, String description, double price , int stock){
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }





}
