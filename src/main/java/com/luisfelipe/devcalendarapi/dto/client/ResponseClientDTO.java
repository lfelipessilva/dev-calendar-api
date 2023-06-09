package com.luisfelipe.devcalendarapi.dto.client;

import com.luisfelipe.devcalendarapi.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseClientDTO {
    private Long id;
    private String name;
    private String email;
}
