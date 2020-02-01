package hu.charmanthere.ease.dao.interfaces;

import hu.charmanthere.ease.dao.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepositoryInterface extends JpaRepository<Event, Long> {
}
