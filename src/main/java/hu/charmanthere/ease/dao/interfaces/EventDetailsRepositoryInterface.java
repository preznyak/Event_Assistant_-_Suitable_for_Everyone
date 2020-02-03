package hu.charmanthere.ease.dao.interfaces;

import hu.charmanthere.ease.dao.entities.EventDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDetailsRepositoryInterface extends JpaRepository<EventDetails, Long> {
}
