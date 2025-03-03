package com.bdb.app_back.dto;

import lombok.Data;

@Data
public class EventsDTO {
    private String eventName;
    private String eventDate;
    private String eventDesc;
    private String eventLocation;
}
