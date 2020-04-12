package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.controller.model.user.UserModel;
import hu.charmanthere.ease.dao.entity.Address;
import hu.charmanthere.ease.dao.entity.Contact;
import hu.charmanthere.ease.dao.entity.User;
import hu.charmanthere.ease.exception.*;
import hu.charmanthere.ease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{userId}")
    public ResponseEntity<?> deleteUserByUserId(@PathVariable Long userId) {
        userService.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            userService.create(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all/model")
    public ResponseEntity<?> findAllUser() {
        return new ResponseEntity<>(userService.findAllModel(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all/list")
    public ResponseEntity<?> findAllUserListModel() {
        return new ResponseEntity<>(userService.findAllUserListModel(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Long id,@RequestBody User user) {
        try {
            userService.update(id, user);
        } catch (UserWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/email/{email}")
    public ResponseEntity<?> findUserByEmail(@PathVariable String email) {
        try {
            return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
        } catch (UserWithEmailDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/id/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
        } catch (UserWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/add/address")
    public ResponseEntity<?> addAddressToUser(@RequestBody Address address, @RequestParam("userId") Long userId){
        try {
            userService.addAddressToUser(address, userId);
        } catch (UserWithIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/add/contact")
    public ResponseEntity<?> addContactToUser(@RequestBody Contact contact, @RequestParam("userId") Long userId){
        try {
            userService.addContactToUser(contact, userId);
        } catch (UserWithIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (UserAlreadyHasContactException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
