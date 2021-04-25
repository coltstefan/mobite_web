package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"products"})
@ToString(exclude = {"products"})
@NoArgsConstructor
public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "restaurant" , cascade = CascadeType.DETACH)
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product p){
        products.add(p);
        p.setRestaurant(this);
    }

    public Restaurant(String name) {
        this.name = name;
    }
}
