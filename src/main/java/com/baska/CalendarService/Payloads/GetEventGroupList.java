package com.baska.CalendarService.Payloads;

public class GetEventGroupList {

    Long id;
    String name;
    String role;

    public GetEventGroupList(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
