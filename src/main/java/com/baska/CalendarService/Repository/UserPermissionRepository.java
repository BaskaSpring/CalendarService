package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPermissionRepository  extends JpaRepository<Long, UserPermission> {

    @Query("select x from UserPermission as x where x.eventId=:eventId and x.userId =:userId")
    UserPermission findByEventIdAndUserId(Long eventId, Long userId);

    @Query("select distinct x.eventId from UserPermission as x where x.userId=:userId and x.eventId in (:eventsId)")
    List<Long> getByUserAndEvents(Long userId, List<Long> evetnsId);

}
