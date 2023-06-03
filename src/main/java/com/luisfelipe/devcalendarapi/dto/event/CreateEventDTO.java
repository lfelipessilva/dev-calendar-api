package com.luisfelipe.devcalendarapi.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class CreateEventDTO {
    private Long clientId;
    private Date start;
    private Date end;
    private String color;
}
