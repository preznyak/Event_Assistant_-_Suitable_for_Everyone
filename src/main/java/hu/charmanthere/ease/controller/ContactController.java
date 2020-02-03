package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entities.Contact;
import hu.charmanthere.ease.dao.interfaces.ContactRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController{

    private ContactRepositoryInterface contactRepositoryInterface;

    @Autowired
    public ContactController(ContactRepositoryInterface contactRepositoryInterface) {
        this.contactRepositoryInterface = contactRepositoryInterface;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllContact() {
        return new ResponseEntity<>(contactRepositoryInterface.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createContact(@RequestBody Contact contact) {
        contactRepositoryInterface.save(contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> updateContactById(@PathVariable Long id,@RequestBody Contact contact) {
        Contact contactToBeUpdated = contactRepositoryInterface.findById(id).orElse(null);
        if(contactToBeUpdated == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        contactToBeUpdated.setEmail(contact.getEmail());
        contactToBeUpdated.setName(contact.getName());
        contactToBeUpdated.setFacebookLink(contact.getFacebookLink());
        contactToBeUpdated.setPhoneNumber(contact.getPhoneNumber());
        contactRepositoryInterface.save(contactToBeUpdated);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{contactId}")
    public ResponseEntity<?> deleteContactByUserId(@PathVariable Long contactId) {
        contactRepositoryInterface.deleteById(contactId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
