package com.bdb.app_back.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "events")
@Data // Getters, Setters...
public class EventsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "event_date")
    private String eventDate;
    @Column(name = "event_desc")
    private String eventDesc;
    @Column(name = "event_location")
    private String eventLocation;
}
