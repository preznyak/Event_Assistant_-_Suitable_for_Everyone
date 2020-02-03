package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entities.User;
import hu.charmanthere.ease.dao.interfaces.UserRepositoryInterface;
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

    public List<User> findAll() {
        return userRepositoryInterface.findAll();
    }

    public User findByEmail(String email) {
        User user = userRepositoryInterface.findByEmail(email).orElse(null);
        if(user == null){

        }
        return user;
    }

    public User findById(Long id) {
        User user = userRepositoryInterface.findById(id).orElse(null);
        if(user == null){

        }
        return user;
    }
}
