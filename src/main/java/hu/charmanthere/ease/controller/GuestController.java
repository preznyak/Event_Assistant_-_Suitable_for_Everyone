package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entities.Guest;
import hu.charmanthere.ease.exception.GuestWithIdDoesNotExistException;
import hu.charmanthere.ease.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guest")
public class GuestController {

    private GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllGuest() {
        return new ResponseEntity<>(guestService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createGuest(@RequestBody Guest guest) {
        guestService.create(guest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> updateGuestById(@PathVariable Long id, @RequestBody Guest guest) {
        try {
            guestService.updateById(id, guest);
        } catch (GuestWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
    public ResponseEntity<?> deleteGuestByUserId(@PathVariable Long id) {
        guestService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
