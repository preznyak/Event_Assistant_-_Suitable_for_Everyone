package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entities.User;
import hu.charmanthere.ease.dao.interfaces.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRepositoryInterface userRepositoryInterface;

    @Autowired
    public UserController(UserRepositoryInterface userRepositoryInterface) {
        this.userRepositoryInterface = userRepositoryInterface;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{userId}")
    public ResponseEntity<?> deleteUserByUserId(@PathVariable Long userId) {
        userRepositoryInterface.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userRepositoryInterface.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllUser() {
        return new ResponseEntity<>(userRepositoryInterface.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> updateCicaById(@PathVariable Long id,@RequestBody User user) {
        User userToBeUpdated = userRepositoryInterface.findById(id).orElse(null);
        if(userToBeUpdated == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userToBeUpdated.setEmail(user.getEmail());
        userToBeUpdated.setPassword(user.getPassword());
        userRepositoryInterface.save(userToBeUpdated);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/email/{email}")
    public ResponseEntity<?> findUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userRepositoryInterface.findByEmail(email), HttpStatus.OK);
    }

}
