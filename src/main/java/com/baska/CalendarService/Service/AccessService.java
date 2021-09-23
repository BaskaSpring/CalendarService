package com.baska.CalendarService.Service;


import com.baska.CalendarService.Payloads.*;
import com.baska.CalendarService.Repository.*;
import com.baska.CalendarService.models.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@Service
public class AccessService {

    @Autowired
    UserPermissionRepository userPermissionRepository;

    @Autowired
    GroupAndUserRepository groupAndUserRepository;

    @Autowired
    GroupPermissionRepository groupPermissionRepository;

    @Autowired
    EventsDataRepository eventsDataRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    GroupRepository groupRepository;

    public String getEvent(Long eventId,Long userId){
        if (CheckAccess(eventId,userId)){
            EventsData eventsData = eventsDataRepository.getEventById(eventId);
            List<UserPermission> userPermissionList = userPermissionRepository.getPermissionByEventId(eventId);
            List<GetEventUserList> eventUserLists = new ArrayList<>();
            userPermissionList.forEach(x->eventUserLists.add(new GetEventUserList(x.getUserId(),roleRepository.getRoleByRoleId(x.getRoleId()).toString(),usersRepository.getUserNameByUserId(x.getUserId()))));
            List<GroupPermission> groupPermissionList = groupPermissionRepository.getPermissionByEventId(eventId);
            List<GetEventGroupList> eventGroupLists = new ArrayList<>();
            groupPermissionList.forEach(x->eventGroupLists.add(new GetEventGroupList(x.getGroupId(),groupRepository.GetGroupNameByGroupId(x.getGroupId()))));
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
            getEventPayloadResponse.setUserName(usersRepository.getUserNameByUserId(eventsData.getUserId()));
            getEventPayloadResponse.setResource(eventsData.getResource());
            getEventPayloadResponse.setUserPermission(eventUserLists);
            getEventPayloadResponse.setGroupPermission(eventGroupLists);
            new Gson().toJson(getEventPayloadResponse);
        }
        return "access denied";
    }

    private String InstantToString(Instant date){
        Date MyDate = Date.from(date);
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        return formatter.format(MyDate);
    }

    private Boolean CheckAccess(Long eventId ,Long userId){
        UserPermission userPermission = userPermissionRepository.findByEventIdAndUserId(eventId,userId);
        if (userPermission.getId()!=null){
            return true;
        }
        Long groupId = groupAndUserRepository.findGroupByUserId(userId);
        List<EventsData> eventsDataList = eventsDataRepository.findByMtree(eventId);
        Set<Long> groupIds = new HashSet<Long>();
        for (EventsData el:eventsDataList){
            Arrays.stream(el.getmTree().split(".")).forEach(x->groupIds.add(Long.parseLong(x)));
        }
        List<Long> groupListIds = groupPermissionRepository.findByEventsIds(groupIds);
        for (Long el: groupListIds){
            if (el==groupId) {
                return true;
            }
        }
        return false;
    }

    public String getAll(GetEventsPayloadRequest getEventsPayloadRequest){
        List<Long> eventsDataList = eventsDataRepository.findByDate(getEventsPayloadRequest.getDateBegin(),getEventsPayloadRequest.getDateEnd());
        List<Long> userEventsId = userPermissionRepository.getByUserAndEvents(getEventsPayloadRequest.getUserId(),eventsDataList);
        Long groupId = groupAndUserRepository.findGroupByUserId(getEventsPayloadRequest.getUserId());
        List<Long> groupEventsId = groupPermissionRepository.getByGroupAndEvents(groupId,eventsDataList);
        userEventsId.addAll(groupEventsId);
        return new Gson().toJson(new GetEventsPayloadResponse(eventsDataRepository.getByEventsId(userEventsId)));
    }

    public void CalculateAccess(){

    }


}
