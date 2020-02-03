package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entities.Event;
import hu.charmanthere.ease.dao.interfaces.EventRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
public class EventController {
    private EventRepositoryInterface eventRepositoryInterface;

    @Autowired
    public EventController(EventRepositoryInterface eventRepositoryInterface) {
        this.eventRepositoryInterface = eventRepositoryInterface;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{eventId}")
    public ResponseEntity<?> deleteEventByEventId(@PathVariable Long eventId) {
        eventRepositoryInterface.deleteById(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        eventRepositoryInterface.save(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllEvent() {
        return new ResponseEntity<>(eventRepositoryInterface.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{eventId}")
    public ResponseEntity<?> updateEventById(@PathVariable Long eventId, @RequestBody Event event) {
        Event eventToBeUpdated = eventRepositoryInterface.findById(eventId).orElse(null);
        if (eventToBeUpdated == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        eventToBeUpdated.setContractList(event.getContractList());
        eventToBeUpdated.setEventCategory(event.getEventCategory());
        eventToBeUpdated.setEventDetails(event.getEventDetails());
        eventToBeUpdated.setEventName(event.getEventName());
        eventToBeUpdated.setPlace(event.getPlace());
        eventRepositoryInterface.save(eventToBeUpdated);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
