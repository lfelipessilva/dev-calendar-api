package com.luisfelipe.devcalendarapi.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateClientDTO {
    private String name;
    private String email;
    private String password;
}
