package com.baska.CalendarService.Payloads;

public class GetEventUserList {

    Long userId;
    String role;
    String name;

    public GetEventUserList(Long userId, String role, String name) {
        this.userId = userId;
        this.role = role;
        this.name = name;
    }

    public GetEventUserList() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
