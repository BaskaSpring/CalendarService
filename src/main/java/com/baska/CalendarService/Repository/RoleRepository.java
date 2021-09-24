package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.ERole;
import com.baska.CalendarService.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long > {
    @Query("select x.role from Role as x where x.id =:roleId")
    ERole getRoleByRoleId(Long roleId);
}
