package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("select x.status from Status as x where x.id=:statusId")
    String getStatusById(Long statusId);
}
