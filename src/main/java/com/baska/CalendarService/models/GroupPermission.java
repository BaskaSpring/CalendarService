package com.baska.CalendarService.models;


import javax.persistence.*;

@Entity
@Table(name = "grouppermission")
public class GroupPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventsId;

    private Long groupId;

    private Long roleId;

    public GroupPermission(Long id, Long eventsId, Long groupId, Long roleId) {
        this.id = id;
        this.eventsId = eventsId;
        this.groupId = groupId;
        this.roleId = roleId;
    }

    public GroupPermission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventsId() {
        return eventsId;
    }

    public void setEventsId(Long eventsId) {
        this.eventsId = eventsId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
