package hu.charmanthere.ease.dao.implementation;

import hu.charmanthere.ease.dao.entity.User;
import hu.charmanthere.ease.dao.inteface.UserDaoInterface;
import hu.charmanthere.ease.dao.repository.UserRepositoryInterface;
import hu.charmanthere.ease.exception.UserWithEmailDoesNotExistException;
import hu.charmanthere.ease.exception.UserWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImpl implements UserDaoInterface {

    private UserRepositoryInterface userRepositoryInterface;

    @Autowired
    public UserDaoImpl(UserRepositoryInterface userRepositoryInterface) {
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
        if(userToBeUpdated == null){
            System.out.println("User with id " + id + " does not exist!");
            throw new UserWithIdDoesNotExistException("User with id " + id + " does not exist!");
        }
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
