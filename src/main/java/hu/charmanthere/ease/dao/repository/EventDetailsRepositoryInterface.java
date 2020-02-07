package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.EventDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDetailsRepositoryInterface extends JpaRepository<EventDetails, Long> {
}
