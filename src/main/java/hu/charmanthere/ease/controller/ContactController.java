package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entity.Contact;
import hu.charmanthere.ease.exception.ContactWithIdDoesNotExistException;
import hu.charmanthere.ease.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController{

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllContact() {
        return new ResponseEntity<>(contactService.findAllContact(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(contactService.findById(id), HttpStatus.OK);
        } catch (ContactWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createContact(@RequestBody Contact contact) {
        contactService.createContact(contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> updateContactById(@PathVariable Long id,@RequestBody Contact contact) {
        try {
            contactService.update(id,contact);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ContactWithIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{contactId}")
    public ResponseEntity<?> deleteContactByUserId(@PathVariable Long contactId) {
        contactService.deleteById(contactId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
