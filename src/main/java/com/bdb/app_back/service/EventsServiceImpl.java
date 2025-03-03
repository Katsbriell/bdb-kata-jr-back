package com.bdb.app_back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bdb.app_back.model.EventsEntity;
import com.bdb.app_back.repository.EventsRepository;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Override
    public ResponseEntity<EventsEntity> createEvent(EventsEntity event) {
        try {
            EventsEntity newEvent = eventsRepository.save(event);
            return ResponseEntity.status(HttpStatus.CREATED).body(newEvent);
        } catch (Exception e) {
            System.out.println("ERROR::createEvent" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<List<EventsEntity>> getAllEvents() {
        try {
            List<EventsEntity> allEvents = eventsRepository.findAll();
            if (allEvents.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(allEvents);
        } catch (Exception e) {
            System.out.println("ERROR::getAllEvents" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<Optional<EventsEntity>> getEvent(Long id) {
        try {
            Optional<EventsEntity> event = eventsRepository.findById(id);
            if (event.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(event);
        } catch (Exception e) {
            System.out.println("ERROR::getEvent" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @Override
    public ResponseEntity<EventsEntity> updateEvent(Long id, EventsEntity event) {
        try {
            Optional<EventsEntity> selectedE = eventsRepository.findById(id);

            if (selectedE.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            EventsEntity updatedE = selectedE.get();
            updatedE.setEventName(event.getEventName());
            updatedE.setEventDate(event.getEventDate());
            updatedE.setEventDesc(event.getEventDesc());
            updatedE.setEventLocation(event.getEventLocation());

            return ResponseEntity.ok(eventsRepository.save(updatedE));

        } catch (Exception e) {
            System.out.println("ERROR::updateEvent" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<String> deleteEvent(Long id) {
        try {
            Optional<EventsEntity> selectedE = eventsRepository.findById(id);
            if (selectedE.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            eventsRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            System.out.println("ERROR::deleteEvent" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
