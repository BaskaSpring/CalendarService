package com.baska.CalendarService.Payloads;

public class AddEventUserList {
    Long id;
    String role;

    public AddEventUserList(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public AddEventUserList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
