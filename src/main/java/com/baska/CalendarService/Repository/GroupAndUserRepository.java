package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.GroupAndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupAndUserRepository extends JpaRepository<Long, GroupAndUser> {
    @Query("select x.groupId from GroupAndUser as x where x.userId=:userId")
    Long findGroupByUserId(Long userId);
}
