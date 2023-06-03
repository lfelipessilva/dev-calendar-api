package com.luisfelipe.devcalendarapi.controller;

import com.luisfelipe.devcalendarapi.dto.client.CreateClientDTO;
import com.luisfelipe.devcalendarapi.dto.client.Mapper;
import com.luisfelipe.devcalendarapi.dto.client.ResponseClientDTO;
import com.luisfelipe.devcalendarapi.entities.Client;
import com.luisfelipe.devcalendarapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientRepository clientRepository;
    private final Mapper mapper;

    @Autowired
    public ClientController(ClientRepository clientRepository, Mapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ResponseClientDTO> getClient(@PathVariable Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);

        return client.map(c -> ResponseEntity.ok().body(mapper.toDto(c)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ResponseClientDTO> createClient(@RequestBody CreateClientDTO clientDTO) {
        Client client = mapper.toClient(clientDTO);
        Client createdClient = clientRepository.save(client);

        return ResponseEntity.ok().body(mapper.toDto(createdClient));
    }
}
