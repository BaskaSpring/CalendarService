package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("select x.parentId from Group as x where x.id =:groupId")
    Long GetParentIdByGroupId(Long groupId);

    @Query("select  x.name from Group as x where x.id=:groupId")
    String GetGroupNameByGroupId(Long groupId);
}
