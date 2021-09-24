package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("select x.name from Users as x where x.userId=:userId")
    String getUserNameByUserId(Long userId);
}
