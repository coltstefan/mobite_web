package com.example.demo.repositories;


import com.example.demo.domain.Client;
import com.example.demo.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client,Long>{

    List<Client> findAll();
    List<Client> findByRestaurant(Restaurant restaurant);



}
