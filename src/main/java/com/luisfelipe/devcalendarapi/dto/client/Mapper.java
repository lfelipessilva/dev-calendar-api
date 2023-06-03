package com.luisfelipe.devcalendarapi.dto.client;

import com.luisfelipe.devcalendarapi.dto.client.CreateClientDTO;
import com.luisfelipe.devcalendarapi.dto.client.ResponseClientDTO;
import com.luisfelipe.devcalendarapi.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public ResponseClientDTO toDto(Client client) {
        Long id = client.getId();
        String name = client.getName();
        String email = client.getEmail();
        return new ResponseClientDTO(id, name, email);
    }

    public Client toClient(CreateClientDTO clientDTO) {
        return new Client(clientDTO.getName(), clientDTO.getEmail(), clientDTO.getPassword());
    }
}