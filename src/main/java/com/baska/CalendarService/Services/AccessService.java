package com.baska.CalendarService.Services;


import com.baska.CalendarService.Repository.GroupAndUserRepository;
import com.baska.CalendarService.Repository.GroupPermissionRepository;
import com.baska.CalendarService.Repository.UserPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessService {


    public Boolean CheckAccess (Long eventId ,Long userId){

        return false;
    }
}
