package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.User;
import hu.charmanthere.ease.dao.implementation.UserDaoImpl;
import hu.charmanthere.ease.exception.UserValidationException;
import hu.charmanthere.ease.exception.UserWithEmailDoesNotExistException;
import hu.charmanthere.ease.exception.UserWithIdDoesNotExistException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {
    private final static Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private UserDaoImpl userDao;

    @Autowired
    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void deleteById(Long userId) {
        userDao.deleteById(userId);
    }

    public void create(User user) throws UserValidationException {
        validateUser(user);
        user.getUserDetails().setRegistrationDate(LocalDate.now());
        userDao.save(user);
    }

    private void validateUser(User user) throws UserValidationException {
        if(StringUtils.isBlank(user.getEmail())){
            LOGGER.info("Email was null or empty.");
            throw new UserValidationException("Email must not be empty.");
        }
        if(StringUtils.isBlank(user.getPassword())){
            LOGGER.info("Password was null or empty.");
            throw new UserValidationException("Password must not be empty.");
        }
        if(StringUtils.isBlank(user.getUserDetails().getFirstName())){
            LOGGER.info("FirstName was null or empty.");
            throw new UserValidationException("First Name must not be empty.");
        }
        if(StringUtils.isBlank(user.getUserDetails().getLastName())){
            LOGGER.info("LastName was null or empty.");
            throw new UserValidationException("Last Name must not be empty.");
        }
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void update(Long id, User user) throws UserWithIdDoesNotExistException {
        userDao.update(id, user);
    }

    public User findByEmail(String email) throws UserWithEmailDoesNotExistException {
        return userDao.findByEmail(email);
    }

    public User findById(Long id) throws UserWithIdDoesNotExistException {
        return userDao.findById(id);
    }
}
