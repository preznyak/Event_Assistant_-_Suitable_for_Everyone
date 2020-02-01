package hu.charmanthere.ease.dao.interfaces;

import hu.charmanthere.ease.dao.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepositoryInterface extends JpaRepository<UserDetails, Long> {
}
