package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepositoryInterface extends JpaRepository<Guest, Long> {
}
