package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.User;
import hu.charmanthere.ease.dao.implementation.UserDaoImpl;
import hu.charmanthere.ease.exception.UserWithEmailDoesNotExistException;
import hu.charmanthere.ease.exception.UserWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDaoImpl userDao;

    @Autowired
    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void deleteById(Long userId) {
        userDao.deleteById(userId);
    }

    public void create(User user) {
        userDao.save(user);
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
