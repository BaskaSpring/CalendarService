package com.baska.CalendarService.Service;


import com.baska.CalendarService.Payloads.GetEventsPayloadRequest;
import com.baska.CalendarService.Repository.EventsDataRepository;
import com.baska.CalendarService.Repository.GroupAndUserRepository;
import com.baska.CalendarService.Repository.GroupPermissionRepository;
import com.baska.CalendarService.Repository.UserPermissionRepository;
import com.baska.CalendarService.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Boolean CheckAccess(Long eventId ,Long userId){
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
        List<Long> groupIdList =
        return "";
    }


}
