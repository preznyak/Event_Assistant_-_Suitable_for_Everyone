package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entities.User;
import hu.charmanthere.ease.dao.interfaces.UserRepositoryInterface;
import hu.charmanthere.ease.exception.UserWithEmailDoesNotExistException;
import hu.charmanthere.ease.exception.UserWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepositoryInterface userRepositoryInterface;

    @Autowired
    public UserService(UserRepositoryInterface userRepositoryInterface) {
        this.userRepositoryInterface = userRepositoryInterface;
    }

    public void deleteById(Long userId) {
        userRepositoryInterface.deleteById(userId);
    }

    public void save(User user) {
        userRepositoryInterface.save(user);
    }

    public void update(Long id, User user) throws UserWithIdDoesNotExistException {
        User userToBeUpdated = findById(id);
        userToBeUpdated.setEmail(user.getEmail());
        userToBeUpdated.setPassword(user.getPassword());
        userToBeUpdated.setLastLoginDate(user.getLastLoginDate());
        userToBeUpdated.setUserDetails(user.getUserDetails());
        userRepositoryInterface.save(userToBeUpdated);
    }

    public List<User> findAll() {
        return userRepositoryInterface.findAll();
    }

    public User findByEmail(String email) throws UserWithEmailDoesNotExistException {
        User user = userRepositoryInterface.findByEmail(email).orElse(null);
        if(user == null){
            System.out.println("User with " + email + " does not exist!");
            throw new UserWithEmailDoesNotExistException("User with " + email + " does not exist!");
        }
        return user;
    }

    public User findById(Long id) throws UserWithIdDoesNotExistException {
        User user = userRepositoryInterface.findById(id).orElse(null);
        if(user == null){
            System.out.println("User with " + id + " does not exist!");
            throw new UserWithIdDoesNotExistException("User with " + id + " does not exist!");
        }
        return user;
    }
}
