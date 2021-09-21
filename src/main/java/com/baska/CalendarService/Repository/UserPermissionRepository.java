package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionRepository  extends JpaRepository<Long, UserPermission> {


    @Query("SELECT x from UserPermission as x where x.userId=:userId and x.eventsId =:eventId")
    UserPermission findByUserIdAndEventId (Long userId, Long eventId);
}
