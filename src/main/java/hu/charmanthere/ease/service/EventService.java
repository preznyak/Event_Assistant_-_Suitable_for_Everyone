package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entities.Event;
import hu.charmanthere.ease.dao.interfaces.EventRepositoryInterface;
import hu.charmanthere.ease.exception.EventWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private EventRepositoryInterface eventRepositoryInterface;

    @Autowired
    public EventService(EventRepositoryInterface eventRepositoryInterface) {
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
        if(event == null){
            System.out.println("Event with id : " +eventId+ " does not exist!");
            throw new EventWithIdDoesNotExistException("Event with id : " +eventId+ " does not exist!");
        }
        eventToBeUpdated.setContractList(event.getContractList());
        eventToBeUpdated.setEventCategory(event.getEventCategory());
        eventToBeUpdated.setEventDetails(event.getEventDetails());
        eventToBeUpdated.setEventName(event.getEventName());
        eventToBeUpdated.setPlace(event.getPlace());
        eventRepositoryInterface.save(eventToBeUpdated);
    }
}
