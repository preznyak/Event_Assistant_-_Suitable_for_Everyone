package hu.charmanthere.ease.dao.interfaces;

import hu.charmanthere.ease.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryInterface extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
