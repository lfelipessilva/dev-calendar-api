package com.luisfelipe.devcalendarapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserDTO {
    private String name;
    private String email;
    private String password;
}
