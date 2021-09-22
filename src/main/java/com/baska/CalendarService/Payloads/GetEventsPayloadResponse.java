package com.baska.CalendarService.Payloads;

import com.baska.CalendarService.models.EventsData;

import java.util.List;

public class GetEventsPayloadResponse {
    List<EventsData> data;

    public GetEventsPayloadResponse(List<EventsData> data) {
        this.data = data;
    }

    public GetEventsPayloadResponse() {
    }

    public List<EventsData> getData() {
        return data;
    }

    public void setData(List<EventsData> data) {
        this.data = data;
    }
}
