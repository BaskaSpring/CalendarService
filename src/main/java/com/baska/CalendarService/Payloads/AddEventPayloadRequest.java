package com.baska.CalendarService.Payloads;

import java.time.Instant;
import java.util.List;

public class AddEventPayloadRequest {

    private String title;
    private String text;
    private Instant dateBegin;
    private Instant dateEnd;
    private Integer completePercent;
    private Integer parentCompletePercent;
    private String resource;
    private Long userId;
    private String status;
    private Long parentId;
    private List<AddEventGroupList> eventGroupList;
    private List<AddEventUserList> eventUserList;


    public AddEventPayloadRequest(String title, String text, Instant dateBegin, Instant dateEnd, Integer completePercent, Integer parentCompletePercent, String resource, Long userId, String status, Long parentId, List<AddEventGroupList> eventGroupList, List<AddEventUserList> eventUserList) {
        this.title = title;
        this.text = text;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.completePercent = completePercent;
        this.parentCompletePercent = parentCompletePercent;
        this.resource = resource;
        this.userId = userId;
        this.status = status;
        this.parentId = parentId;
        this.eventGroupList = eventGroupList;
        this.eventUserList = eventUserList;
    }

    public AddEventPayloadRequest() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<AddEventGroupList> getEventGroupList() {
        return eventGroupList;
    }

    public void setEventGroupList(List<AddEventGroupList> eventGroupList) {
        this.eventGroupList = eventGroupList;
    }

    public List<AddEventUserList> getEventUserList() {
        return eventUserList;
    }

    public void setEventUserList(List<AddEventUserList> eventUserList) {
        this.eventUserList = eventUserList;
    }
}
