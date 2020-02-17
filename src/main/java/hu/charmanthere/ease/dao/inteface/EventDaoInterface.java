package hu.charmanthere.ease.dao.inteface;

import hu.charmanthere.ease.dao.entity.Event;
import hu.charmanthere.ease.dao.enumeration.EventCategory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EventDaoInterface {
    List<Event> findEventsByEventCategory(EventCategory eventCategory);
    List<Event> findEventsByLocality(String locality);
    List<Event> findEventsByDateTime(LocalDateTime localDateTime);
}
