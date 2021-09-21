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
}
