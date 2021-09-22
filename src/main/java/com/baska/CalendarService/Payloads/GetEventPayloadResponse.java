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

    private Long userId;

    private Long statusId;

    private Long parentId;

    private List<Group> groupPermission;

    private List<Long> userPermission;

}
