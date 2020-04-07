package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entity.User;
import hu.charmanthere.ease.exception.UserValidationException;
import hu.charmanthere.ease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usermanagement")
public class UserManagementController {

    private UserService userService;

    @Autowired
    public UserManagementController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create/user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try {
            userService.create(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/user")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        userService.deleteById(user.getUserId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
