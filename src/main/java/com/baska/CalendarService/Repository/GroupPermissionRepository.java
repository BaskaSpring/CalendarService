package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.GroupPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface GroupPermissionRepository extends JpaRepository<Long, GroupPermission> {

    @Query("select x from GroupPermission as x where x.groupId =:groupId and x.eventsId=:eventId")
    GroupPermission GetEventsByGroupIdAndEventId(Long groupId,Long eventId);

    @Query("select x.groupId from GroupPermission as x where x.eventsId in (:eventsIds)")
    List<Long> findByEventsIds(Set<Long> eventsIds);


}
