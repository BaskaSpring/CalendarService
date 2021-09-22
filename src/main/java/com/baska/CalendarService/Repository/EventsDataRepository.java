package com.baska.CalendarService.Repository;

import com.baska.CalendarService.models.EventsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface EventsDataRepository extends JpaRepository<Long, EventsData> {

    @Query("select x from EventsData as x where x.mTree like CONCAT('%.',:eventId)")
    List<EventsData> findByMtree(Long eventId);


    @Query("select distinct x.idEvent from EventsData  as x where ((x.dateBegin>=:dateBegin)and(x.dateBegin<=:dateEnd))or((x.dateEnd>=:dateBegin)and(x.dateEnd<=:dateEnd))")
    List<Long> findByDate(Instant dateBegin,Instant dateEnd);
}
