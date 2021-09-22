package com.baska.CalendarService.Payloads;

public class GetEventPayloadRequest {
    Long eventId;
    Long userId;

    public GetEventPayloadRequest(Long eventId, Long userId) {
        this.eventId = eventId;
        this.userId = userId;
    }

    public GetEventPayloadRequest() {
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
