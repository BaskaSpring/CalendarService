package com.baska.CalendarService.Payloads;

import com.baska.CalendarService.models.Group;

import java.util.List;

public class GetEventPayloadResponse {

    private Long idEvent;

    private String timestamp;

    private String title;

    private String text;

    private String dateBegin;

    private String dateEnd;

    private Integer completePercent;

    private Integer parentCompletePercent;

    private String resource;

    private String userName;

    private String statusId;

    private List<GetEventGroupList> groupPermission;

    private List<GetEventUserList> userPermission;

    public GetEventPayloadResponse(Long idEvent, String timestamp, String title, String text, String dateBegin, String dateEnd, Integer completePercent, Integer parentCompletePercent, String resource, String userName, String statusId, List<GetEventGroupList> groupPermission, List<GetEventUserList> userPermission) {
        this.idEvent = idEvent;
        this.timestamp = timestamp;
        this.title = title;
        this.text = text;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.completePercent = completePercent;
        this.parentCompletePercent = parentCompletePercent;
        this.resource = resource;
        this.userName = userName;
        this.statusId = statusId;
        this.groupPermission = groupPermission;
        this.userPermission = userPermission;
    }

    public GetEventPayloadResponse() {
    }

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
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

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public List<GetEventGroupList> getGroupPermission() {
        return groupPermission;
    }

    public void setGroupPermission(List<GetEventGroupList> groupPermission) {
        this.groupPermission = groupPermission;
    }

    public List<GetEventUserList> getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(List<GetEventUserList> userPermission) {
        this.userPermission = userPermission;
    }
}
