package com.example.demo.services;

import com.example.demo.domain.Client;
import com.example.demo.domain.Restaurant;
import com.example.demo.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Client save(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findByRestaurant(Restaurant restaurant) {
        return clientRepository.findByRestaurant(restaurant);
    }
}
