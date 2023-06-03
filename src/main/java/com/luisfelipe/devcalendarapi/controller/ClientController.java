package com.luisfelipe.devcalendarapi.controller;

import com.luisfelipe.devcalendarapi.entities.Client;
import com.luisfelipe.devcalendarapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> getUsers() {
        return clientRepository.findAll();
    }

    @PostMapping
    public Client createUser(@RequestBody Client client) {
        return clientRepository.save(client);
    }
}
