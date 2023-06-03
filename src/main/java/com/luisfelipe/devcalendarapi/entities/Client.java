package com.luisfelipe.devcalendarapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;


@NoArgsConstructor
@Entity
@Getter
@Setter
public class Client {

    public Client(String name, String email, String password) {
        this.name = Objects.requireNonNull(name);
        this.email= Objects.requireNonNull(email);
        this.password = this.encrypt(password);
    }

    private String encrypt(String password) {
        return password;
    }

    @Id()
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Event> events;
}
