package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionRepository  extends JpaRepository<Long, UserPermission> {


}
