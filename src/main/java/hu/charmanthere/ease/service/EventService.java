package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.Event;
import hu.charmanthere.ease.dao.implementation.EventDaoImpl;
import hu.charmanthere.ease.exception.EventWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventService {
    public EventDaoImpl eventDao;

    @Autowired
    public EventService(EventDaoImpl eventDao) {
        this.eventDao = eventDao;
    }

    public List<Event> findAllEvent() {
        return eventDao.findAll();
    }

    public Event findById(Long id) throws EventWithIdDoesNotExistException {
        return eventDao.findById(id);
    }

    public void createEvent(Event event) {
        eventDao.save(event);
    }

    public void update(Long id, Event event) throws EventWithIdDoesNotExistException {
        eventDao.update(id,event);
    }

    public void deleteById(Long id) {
        eventDao.deleteById(id);
    }
}
