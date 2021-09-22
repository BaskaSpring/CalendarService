package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionRepository  extends JpaRepository<Long, UserPermission> {

    @Query("select x from UserPermission as x where x.eventId=:eventId and x.userId =:userId")
    UserPermission findByEventIdAndUserId(Long eventId, Long userId);


}
