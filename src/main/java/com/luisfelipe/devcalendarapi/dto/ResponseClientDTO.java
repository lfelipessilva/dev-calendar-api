package com.luisfelipe.devcalendarapi.dto;

import com.luisfelipe.devcalendarapi.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseClientDTO {
    private Long id;
    private String name;
    private String email;

    public static ResponseClientDTO toDTO(Client client) {
        return new ResponseClientDTO(client.getId(), client.getName(), client.getEmail());
    }
}
