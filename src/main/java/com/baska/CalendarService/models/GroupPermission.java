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
}
