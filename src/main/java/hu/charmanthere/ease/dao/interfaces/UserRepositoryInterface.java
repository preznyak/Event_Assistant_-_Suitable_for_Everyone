package hu.charmanthere.ease.dao.interfaces;

import hu.charmanthere.ease.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryInterface extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
