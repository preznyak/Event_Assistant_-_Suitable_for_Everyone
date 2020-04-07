package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.Event;
import hu.charmanthere.ease.dao.enumeration.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepositoryInterface extends JpaRepository<Event, Long> {

    List<Event> findEventsByEventCategory(EventCategory eventCategory);
    List<Event> findEventsByLocality(String locality);
    List<Event> findEventsByEventDetails_StartTime(LocalDateTime localDateTime);
}
