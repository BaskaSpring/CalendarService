package com.baska.CalendarService.Repository;

import com.baska.CalendarService.Payloads.GetEventUserList;
import com.baska.CalendarService.models.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {

    @Query("select x from UserPermission as x where x.eventId=:eventId and x.userId =:userId")
    UserPermission findByEventIdAndUserId(Long eventId, Long userId);

    @Query("select distinct x.eventId from UserPermission as x where x.userId=:userId and x.eventId in (:eventsId)")
    List<Long> getByUserAndEvents(Long userId, List<Long> eventsId);

    @Query("select x from UserPermission as x where x.eventId =:eventId")
    List<UserPermission> getPermissionByEventId(Long eventId);

    @Query(value="select x.eventId,u.name,r.role from UserPermission as x left join Users as u on x.userId=u.userId left join Role as r on x.roleId=r.id where x.eventId=:eventId",nativeQuery=true)
    List<GetEventUserList> getUserList(Long eventId);

}
