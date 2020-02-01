package hu.charmanthere.ease.dao.interfaces;

import hu.charmanthere.ease.dao.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepositoryInterface extends JpaRepository<Service, Long> {
}
