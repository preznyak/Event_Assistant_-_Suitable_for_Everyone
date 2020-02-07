package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepositoryInterface extends JpaRepository<Offer, Long> {
}
