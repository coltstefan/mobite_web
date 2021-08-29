package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"restaurant","comenzi"})
@ToString(exclude = {"restaurant","comenzi"})
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Restaurant restaurant;

    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>();

    public void addOrder(Order order){
        orders.add(order);
        order.setClient(this);
    }


    public Client(String name){
        this.name = name;
    }

}
