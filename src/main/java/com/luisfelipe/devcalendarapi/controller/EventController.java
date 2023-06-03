package com.luisfelipe.devcalendarapi.controller;

import com.luisfelipe.devcalendarapi.dto.CreateEventDTO;
import com.luisfelipe.devcalendarapi.entities.Client;
import com.luisfelipe.devcalendarapi.entities.Event;
import com.luisfelipe.devcalendarapi.repositories.ClientRepository;
import com.luisfelipe.devcalendarapi.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {


    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ClientRepository clientRepository;

    private CreateEventDTO createEventDTO;

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Event>> getClient(@PathVariable("clientId") Long clientId) {
        List<Event> events = eventRepository.findByClientId(clientId);

        if (events.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(events);
        }
    }


    @PostMapping
    public Event createEvent(@RequestBody CreateEventDTO eventDTO) {
        Client client = clientRepository.findById(eventDTO.getClientId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid clientId: " + eventDTO.getClientId()));

        Event event = new Event();
        event.setClient(client);
        event.setStart(eventDTO.getStart());
        event.setEnd(eventDTO.getEnd());
        event.setColor(eventDTO.getColor());

        return eventRepository.save(event);
    }
}
