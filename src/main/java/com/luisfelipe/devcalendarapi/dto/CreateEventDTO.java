package com.luisfelipe.devcalendarapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CreateEventDTO {
    private Long clientId;
    private Date start;
    private Date end;
    private String color;
}
