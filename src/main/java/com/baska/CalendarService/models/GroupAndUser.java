package com.baska.CalendarService.models;

import javax.persistence.*;

@Entity
@Table(name = "groupuser")
public class GroupAndUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long groupId;
    Long userId;


    public GroupAndUser(Long id, Long groupId, Long userId) {
        this.id = id;
        this.groupId = groupId;
        this.userId = userId;
    }

    public GroupAndUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
