package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entity.Event;
import hu.charmanthere.ease.dao.enumeration.EventCategory;
import hu.charmanthere.ease.exception.EventWithIdDoesNotExistException;
import hu.charmanthere.ease.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/event")
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{eventId}")
    public ResponseEntity<?> deleteEventByEventId(@PathVariable Long eventId) {
        eventService.deleteById(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllEvent() {
        return new ResponseEntity<>(eventService.findAllEvent(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(eventService.findById(id), HttpStatus.OK);
        } catch (EventWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{eventId}")
    public ResponseEntity<?> updateEventById(@PathVariable Long eventId, @RequestBody Event event) {
        try {
            eventService.update(eventId,event);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EventWithIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/category/{category}")
    public ResponseEntity<?> findEventsByEventCategory(@PathVariable EventCategory category) {
        return new ResponseEntity<>(eventService.findEventsByEventCategory(category), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/locality/{locality}")
    public ResponseEntity<?> findEventsByEventCategory(@PathVariable String locality) {
        return new ResponseEntity<>(eventService.findEventsByLocality(locality), HttpStatus.OK);
    }

    //TODO
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/date")
    public ResponseEntity<?> findEventsByEventCategory(@RequestParam("localDate")
                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        return new ResponseEntity<>(eventService.findEventsByDate(localDate), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/getbudget/{id}")
    public ResponseEntity<?> findEventsByEventCategory(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(eventService.getEventBudgetByEventId(id), HttpStatus.OK);
        } catch (EventWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
