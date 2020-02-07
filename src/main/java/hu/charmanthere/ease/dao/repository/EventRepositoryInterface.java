package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepositoryInterface extends JpaRepository<Event, Long> {
}
