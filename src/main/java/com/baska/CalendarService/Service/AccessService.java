package com.baska.CalendarService.Service;


import com.baska.CalendarService.Payloads.*;
import com.baska.CalendarService.Repository.*;
import com.baska.CalendarService.models.ERole;
import com.baska.CalendarService.models.EventsData;
import com.baska.CalendarService.models.GroupPermission;
import com.baska.CalendarService.models.UserPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    UserRepository userRepository;

    @Autowired
    GroupRepository groupRepository;


    public List<GetEventUserList> getEventUserLists(Long eventId){
        //List<UserPermission> userPermissionList = userPermissionRepository.getPermissionByEventId(eventId);
//        List<GetEventUserList> eventUserLists = userPermissionRepository.getUserList(eventId);
//        userPermissionList.forEach(x->eventUserLists.add(new GetEventUserList(x.getUserId(),roleRepository.getRoleByRoleId(x.getRoleId()).toString(),userRepository.getUserNameByUserId(x.getUserId()))));
        return userPermissionRepository.getUserList(eventId);
    }


    public List<GetEventGroupList> getEventGroupLists(Long eventId) {
        List<GroupPermission> groupPermissionList = groupPermissionRepository.getPermissionByEventId(eventId);
        List<GetEventGroupList> eventGroupLists = new ArrayList<>();
        groupPermissionList.forEach(x -> eventGroupLists.add(new GetEventGroupList(x.getGroupId(), groupRepository.GetGroupNameByGroupId(x.getGroupId()),roleRepository.getRoleByRoleId(x.getRoleId()).toString())));
        return eventGroupLists;
    }


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

    public void addUserPermissions(List<AddEventUserList> userList,Long eventId){
        for (AddEventUserList el: userList){
            UserPermission userPermission = new UserPermission();
            userPermission.setEventId(eventId);
            userPermission.setUserId(el.getId());
            if (el.getRole().equals(ERole.WRITE.toString())){
                userPermission.setRoleId(roleRepository.getIdByRole(ERole.WRITE));
            } else {
                userPermission.setRoleId(roleRepository.getIdByRole(ERole.READ));
            }
            userPermissionRepository.save(userPermission);
        }
    }

    public void addGroupPermissions(List<AddEventGroupList> groupList, Long eventId){
        for (AddEventGroupList el: groupList){
            Set<Long> longList = new HashSet<Long>();
            longList.add(el.getId());

        }
//            GroupPermission groupPermission = new GroupPermission();
//            groupPermission.setEventsId(eventId);
//            groupPermission.setGroupId(el.getId());
//            if (el.getRole().equals(ERole.WRITE.toString())){
//                userPermission.setRoleId(roleRepository.getIdByRole(ERole.WRITE));
//            } else {
//                userPermission.setRoleId(roleRepository.getIdByRole(ERole.READ));
//            }
//            userPermissionRepository.save(userPermission);
//        }
    }

    public void rek(Set<Long> longList,Long groupId){
        groupRepository.GetParentIdByGroupId(groupId).
    }



    public void CalculateAccess(){

    }


}
