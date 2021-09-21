package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.GroupPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupPermissionRepository extends JpaRepository<Long, GroupPermission> {

}
