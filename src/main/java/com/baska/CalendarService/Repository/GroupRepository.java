package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Long, Group> {
    @Query("select x.parentId from Group as x where x.id =:groupId")
    Long GetParentIdByGroupId(Long groupId);
}
