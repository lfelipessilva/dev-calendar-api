package com.luisfelipe.devcalendarapi.controller;

import com.luisfelipe.devcalendarapi.dto.ResponseClientDTO;
import com.luisfelipe.devcalendarapi.entities.Client;
import com.luisfelipe.devcalendarapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {


    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/{clientId}")
    public ResponseEntity<?> getClient(@PathVariable Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);

        if (client.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }

        return ResponseEntity.ok(ResponseClientDTO.toDTO(client.get()));
    }

    @PostMapping
    public Client createUser(@RequestBody Client client) {
        return clientRepository.save(client);
    }
}
