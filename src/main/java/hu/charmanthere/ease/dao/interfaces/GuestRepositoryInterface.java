package hu.charmanthere.ease.dao.interfaces;

import hu.charmanthere.ease.dao.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepositoryInterface extends JpaRepository<Guest, Long> {
}
