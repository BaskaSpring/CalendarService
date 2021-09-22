package com.baska.CalendarService.models;

import javax.persistence.*;

@Entity
@Table(name = "userpemission")
public class UserPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    private Long userId;

    private Long roleId;

    public UserPermission(Long id, Long eventId, Long userId, Long roleId) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserPermission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
