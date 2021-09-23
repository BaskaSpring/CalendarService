package com.baska.CalendarService.Payloads;

public class GetEventGroupList {

    Long id;
    String name;

    public GetEventGroupList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GetEventGroupList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
