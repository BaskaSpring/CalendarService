package com.baska.CalendarService.Service;


import com.baska.CalendarService.Payloads.*;
import com.baska.CalendarService.Repository.*;
import com.baska.CalendarService.models.EStatus;
import com.baska.CalendarService.models.Events;
import com.baska.CalendarService.models.EventsData;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@Service
public class CRUDService {

    @Autowired
    AccessService accessService;

    @Autowired
    EventsDataRepository eventsDataRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPermissionRepository userPermissionRepository;

    @Autowired
    GroupAndUserRepository groupAndUserRepository;

    @Autowired
    GroupPermissionRepository groupPermissionRepository;

    @Autowired
    EventsRepository eventsRepository;


    public String addEvent(AddEventPayloadRequest addEventPayloadRequest){
        Boolean existParent = false;
        Events events = new Events();
        eventsRepository.save(events);
        EventsData eventsData = new EventsData();
        eventsData.setCompletePercent(addEventPayloadRequest.getCompletePercent());
        eventsData.setIdEvent(events.getId());
        eventsData.setParentCompletePercent(addEventPayloadRequest.getParentCompletePercent());
        eventsData.setDateBegin(addEventPayloadRequest.getDateBegin());
        eventsData.setDateEnd(addEventPayloadRequest.getDateEnd());
        eventsData.setResource(addEventPayloadRequest.getResource());
        eventsData.setText(addEventPayloadRequest.getText());
        eventsData.setTitle(addEventPayloadRequest.getTitle());
        eventsData.setUserId(addEventPayloadRequest.getUserId());
        eventsData.setStatusId(statusRepository.getIdByStatus(EStatus.ACTIVE));
        if (addEventPayloadRequest.getParentId()>0){
            EventsData parent = eventsDataRepository.getEventById(addEventPayloadRequest.getParentId()).orElse(new EventsData());
            eventsData.setmTree(parent.getmTree()+"."+addEventPayloadRequest.getParentId().toString());
            existParent = true;
        }
        eventsDataRepository.save(eventsData);

        List<Long> eventsIds = new ArrayList<Long>();
        Set<Long> eventsIdList = new HashSet<Long>();
        if (existParent){
            EventsData eventsDataParent = eventsDataRepository.getEventById(events.getId()).orElse(new EventsData());
            String mTree =eventsDataParent.getmTree();
            Arrays.stream(mTree.split("\\.")).forEach(x->eventsIdList.add(Long.parseLong(x)));
            eventsIds.addAll(eventsIdList);
        }
        accessService.addUserPermissions(addEventPayloadRequest.getEventUserList(),events.getId(),eventsIds);
        accessService.addGroupPermissions(addEventPayloadRequest.getEventGroupList(),events.getId(),eventsIdList);
        return "ok";
    }



    public String getEvent(Long eventId,Long userId){
        if (accessService.CheckAccess(eventId,userId)){
            EventsData eventsData = eventsDataRepository.getEventById(eventId).orElse(new EventsData());
            List<GetEventUserList> eventUserLists = accessService.getEventUserLists(eventId);
            List<GetEventGroupList> eventGroupLists = accessService.getEventGroupLists(eventId);
            GetEventPayloadResponse getEventPayloadResponse = new GetEventPayloadResponse();
            getEventPayloadResponse.setCompletePercent(eventsData.getCompletePercent());
            getEventPayloadResponse.setIdEvent(eventsData.getIdEvent());
            getEventPayloadResponse.setStatusId(statusRepository.getStatusById(eventsData.getStatusId()));
            getEventPayloadResponse.setText(eventsData.getText());
            getEventPayloadResponse.setTitle(eventsData.getTitle());
            getEventPayloadResponse.setTimestamp(InstantToString(eventsData.getTimeStamp()));
            getEventPayloadResponse.setDateBegin(InstantToString(eventsData.getDateBegin()));
            getEventPayloadResponse.setDateEnd(InstantToString(eventsData.getDateEnd()));
            getEventPayloadResponse.setParentCompletePercent(eventsData.getParentCompletePercent());
            getEventPayloadResponse.setUserName(userRepository.getUserNameByUserId(eventsData.getUserId()));
            getEventPayloadResponse.setResource(eventsData.getResource());
            getEventPayloadResponse.setUserPermission(eventUserLists);
            getEventPayloadResponse.setGroupPermission(eventGroupLists);
            new Gson().toJson(getEventPayloadResponse);
        }
        return "access denied";
    }


    public String getAll(GetEventsPayloadRequest getEventsPayloadRequest){
        List<Long> eventsDataList = eventsDataRepository.findByDate(getEventsPayloadRequest.getDateBegin(),getEventsPayloadRequest.getDateEnd());
        List<Long> userEventsId = userPermissionRepository.getByUserAndEvents(getEventsPayloadRequest.getUserId(),eventsDataList);
        Long groupId = groupAndUserRepository.findGroupByUserId(getEventsPayloadRequest.getUserId());
        List<Long> groupEventsId = groupPermissionRepository.getByGroupAndEvents(groupId,eventsDataList);
        userEventsId.addAll(groupEventsId);
        return new Gson().toJson(new GetEventsPayloadResponse(eventsDataRepository.getByEventsId(userEventsId)));
    }

    private String InstantToString(Instant date){
        Date MyDate = Date.from(date);
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        return formatter.format(MyDate);
    }

}
