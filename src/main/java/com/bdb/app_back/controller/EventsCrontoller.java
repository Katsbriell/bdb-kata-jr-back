package com.bdb.app_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdb.app_back.model.EventsEntity;
import com.bdb.app_back.service.EventsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/events")
public class EventsCrontoller {
    @Autowired
    private EventsService eventsService;

    @PostMapping
    public ResponseEntity<EventsEntity> createEvent(@RequestBody EventsEntity entity) {
        return eventsService.createEvent(entity);
    }

    @GetMapping
    public ResponseEntity<List<EventsEntity>> getAllEvents() {
        return eventsService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EventsEntity>> getEvent(@PathVariable Long id) {
        return eventsService.getEvent(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventsEntity> updateEvent(@PathVariable Long id,
            @RequestBody EventsEntity event) {
        return eventsService.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        return eventsService.deleteEvent(id);
    }
}
