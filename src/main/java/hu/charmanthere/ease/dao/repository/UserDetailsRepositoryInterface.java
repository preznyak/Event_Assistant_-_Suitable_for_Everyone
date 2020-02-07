package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepositoryInterface extends JpaRepository<UserDetails, Long> {
}
