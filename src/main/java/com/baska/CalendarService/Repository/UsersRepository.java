package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Long, Users> {

    @Query("select x.name from Users as x where x.userId=:userId")
    String getUserNameByUserId(Long userId);
}
