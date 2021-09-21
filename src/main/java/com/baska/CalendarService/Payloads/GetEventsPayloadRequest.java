package com.baska.CalendarService.Payloads;

import java.time.Instant;

public class GetEventsPayloadRequest {
    Instant dateBegin;
    Instant dateEnd;
    Long userId;

    public GetEventsPayloadRequest(Instant dateBegin, Instant dateEnd, Long userId) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.userId = userId;
    }

    public GetEventsPayloadRequest() {
    }

    public Instant getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Instant dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Instant getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Instant dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
