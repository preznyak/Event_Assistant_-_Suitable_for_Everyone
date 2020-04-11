package hu.charmanthere.ease.dao.implementation;

import hu.charmanthere.ease.dao.entity.Event;
import hu.charmanthere.ease.dao.enumeration.EventCategory;
import hu.charmanthere.ease.dao.inteface.EventDaoInterface;
import hu.charmanthere.ease.dao.repository.EventRepositoryInterface;
import hu.charmanthere.ease.exception.EventWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventDaoImpl implements EventDaoInterface {
    private EventRepositoryInterface eventRepositoryInterface;

    @Autowired
    public EventDaoImpl(EventRepositoryInterface eventRepositoryInterface) {
        this.eventRepositoryInterface = eventRepositoryInterface;
    }

    public void deleteById(Long eventId) {
        eventRepositoryInterface.deleteById(eventId);
    }

    public void save(Event event) {
        eventRepositoryInterface.save(event);
    }

    public List<Event> findAll() {
        return eventRepositoryInterface.findAll();
    }

    public Event findById(Long id) throws EventWithIdDoesNotExistException {
        Event event = eventRepositoryInterface.findById(id).orElse(null);
        if(event == null){
            System.out.println("Event with id : " +id+ " does not exist!");
            throw new EventWithIdDoesNotExistException("Event with id : " +id+ " does not exist!");
        }
        return event;
    }

    public void update(Long eventId, Event event) throws EventWithIdDoesNotExistException {
        Event eventToBeUpdated = eventRepositoryInterface.findById(eventId).orElse(null);
        if(eventToBeUpdated == null){
            System.out.println("Event with id : " +eventId+ " does not exist!");
            throw new EventWithIdDoesNotExistException("Event with id : " +eventId+ " does not exist!");
        }
        eventToBeUpdated.setEventCategory(event.getEventCategory());
        eventToBeUpdated.setEventDetails(event.getEventDetails());
        eventToBeUpdated.setEventName(event.getEventName());
        eventToBeUpdated.setLocality(event.getLocality());
        eventToBeUpdated.setAdditionalCostList(event.getAdditionalCostList());
        eventRepositoryInterface.save(eventToBeUpdated);
    }

    @Override
    public List<Event> findEventsByEventCategory(EventCategory eventCategory) {
        return eventRepositoryInterface.findEventsByEventCategory(eventCategory);
    }

    @Override
    public List<Event> findEventsByLocality(String locality) {
        return eventRepositoryInterface.findEventsByLocality(locality);
    }

    @Override
    public List<Event> findEventsByDateTime(LocalDateTime localDateTime) {
        return eventRepositoryInterface.findEventsByEventDetails_StartTime(localDateTime);
    }
}
