package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entity.User;
import hu.charmanthere.ease.exception.UserWithEmailDoesNotExistException;
import hu.charmanthere.ease.exception.UserWithIdDoesNotExistException;
import hu.charmanthere.ease.dao.implementation.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserDaoImpl userDaoImpl;

    @Autowired
    public UserController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{userId}")
    public ResponseEntity<?> deleteUserByUserId(@PathVariable Long userId) {
        userDaoImpl.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userDaoImpl.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllUser() {
        return new ResponseEntity<>(userDaoImpl.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Long id,@RequestBody User user) {
        try {
            userDaoImpl.update(id, user);
        } catch (UserWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/email/{email}")
    public ResponseEntity<?> findUserByEmail(@PathVariable String email) {
        try {
            return new ResponseEntity<>(userDaoImpl.findByEmail(email), HttpStatus.OK);
        } catch (UserWithEmailDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/id/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(userDaoImpl.findById(id), HttpStatus.OK);
        } catch (UserWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }

    //TODO Service, Offer, Event, Contract, Contact, Guest, Address Controller

}
