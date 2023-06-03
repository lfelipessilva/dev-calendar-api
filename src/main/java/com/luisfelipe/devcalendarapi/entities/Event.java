package com.luisfelipe.devcalendarapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Event {

    public Event(Client client, Date start, Date end, String color) {
        this.client = client;
        this.start = start;
        this.end = end;
        this.color = color;
    }

    @Id()
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(nullable = false, name = "start_time")
    private Date start;

    @Column(nullable = false, name = "end_time")
    private Date end;

    @Column()
    private String color;

}
