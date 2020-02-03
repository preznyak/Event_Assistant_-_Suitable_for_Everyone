package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entities.Guest;
import hu.charmanthere.ease.dao.interfaces.GuestRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guest")
public class GuestController {

    private GuestRepositoryInterface guestRepositoryInterface;

    @Autowired
    public GuestController(GuestRepositoryInterface guestRepositoryInterface) {
        this.guestRepositoryInterface = guestRepositoryInterface;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllGuest() {
        return new ResponseEntity<>(guestRepositoryInterface.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createGuest(@RequestBody Guest guest) {
        guestRepositoryInterface.save(guest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> updateGuestById(@PathVariable Long id, @RequestBody Guest guest) {
        Guest guestToBeUpdated = guestRepositoryInterface.findById(id).orElse(null);
        if(guestToBeUpdated == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        guestToBeUpdated.setContact(guest.getContact());
        guestToBeUpdated.setFirstName(guest.getFirstName());
        guestToBeUpdated.setLastName(guest.getFirstName());
        guestToBeUpdated.setInvitationAccepted(guestToBeUpdated.getInvitationAccepted());
        guestRepositoryInterface.save(guestToBeUpdated);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
    public ResponseEntity<?> deleteGuestByUserId(@PathVariable Long id) {
        guestRepositoryInterface.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
