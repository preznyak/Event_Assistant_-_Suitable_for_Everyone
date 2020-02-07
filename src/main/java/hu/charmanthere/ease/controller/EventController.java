package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entity.Event;
import hu.charmanthere.ease.exception.EventWithIdDoesNotExistException;
import hu.charmanthere.ease.dao.implementation.EventDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
public class EventController {
    private EventDaoImpl eventDaoImpl;

    @Autowired
    public EventController(EventDaoImpl eventDaoImpl) {
        this.eventDaoImpl = eventDaoImpl;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{eventId}")
    public ResponseEntity<?> deleteEventByEventId(@PathVariable Long eventId) {
        eventDaoImpl.deleteById(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        eventDaoImpl.save(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllEvent() {
        return new ResponseEntity<>(eventDaoImpl.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(eventDaoImpl.findById(id), HttpStatus.OK);
        } catch (EventWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{eventId}")
    public ResponseEntity<?> updateEventById(@PathVariable Long eventId, @RequestBody Event event) {
        try {
            eventDaoImpl.update(eventId,event);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EventWithIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
