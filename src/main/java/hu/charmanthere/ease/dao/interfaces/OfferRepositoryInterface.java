package hu.charmanthere.ease.dao.interfaces;

import hu.charmanthere.ease.dao.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepositoryInterface extends JpaRepository<Offer, Long> {
}
