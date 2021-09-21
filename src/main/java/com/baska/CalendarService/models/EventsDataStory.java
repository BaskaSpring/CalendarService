package com.baska.CalendarService.models;


import javax.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "eventsDataStory")
public class EventsDataStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idEvent;

    private Instant timestamp = Instant.now();

    private String title;

    private String text;

    private Instant dateBegin;

    private Instant dateEnd;

    private Integer completePercent;

    private Integer parentCompletePercent;

    private String resource;

    private Long userId;

    private Long statusId;

    private String mTree;

    public EventsDataStory(Long id, Long idEvent, Instant timestamp, String title, String text, Instant dateBegin, Instant dateEnd, Integer completePercent, Integer parentCompletePercent, String resource, Long userId, Long statusId, String mTree) {
        this.id = id;
        this.idEvent = idEvent;
        this.timestamp = timestamp;
        this.title = title;
        this.text = text;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.completePercent = completePercent;
        this.parentCompletePercent = parentCompletePercent;
        this.resource = resource;
        this.userId = userId;
        this.statusId = statusId;
        this.mTree = mTree;
    }

    public EventsDataStory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public Instant getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public Integer getCompletePercent() {
        return completePercent;
    }

    public void setCompletePercent(Integer completePercent) {
        this.completePercent = completePercent;
    }

    public Integer getParentCompletePercent() {
        return parentCompletePercent;
    }

    public void setParentCompletePercent(Integer parentCompletePercent) {
        this.parentCompletePercent = parentCompletePercent;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getmTree() {
        return mTree;
    }

    public void setmTree(String mTree) {
        this.mTree = mTree;
    }
}
