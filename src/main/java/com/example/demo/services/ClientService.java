package com.example.demo.services;

import com.example.demo.domain.Client;
import com.example.demo.domain.Restaurant;

import java.util.List;

public interface ClientService {

    Client save(Client c);
    List<Client> findAll();
    List<Client> findByRestaurant(Restaurant restaurant);

}
