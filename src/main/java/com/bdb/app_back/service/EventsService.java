package com.bdb.app_back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.bdb.app_back.model.EventsEntity;

public interface EventsService {

    ResponseEntity<EventsEntity> createEvent(EventsEntity event);

    ResponseEntity<List<EventsEntity>> getAllEvents();

    ResponseEntity<Optional<EventsEntity>> getEvent(Long id);

    ResponseEntity<EventsEntity> updateEvent(Long id, EventsEntity event);

    ResponseEntity<String> deleteEvent(Long id);

}
