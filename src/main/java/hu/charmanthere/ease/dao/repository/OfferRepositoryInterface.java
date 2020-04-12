package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepositoryInterface extends JpaRepository<Offer, Long> {

    List<Offer> findAllByService_ServiceId(Long id);

    List<Offer> findAllByEvent_EventId(Long id);

    List<Offer> findAllByIsOfferAcceptedAndEvent_EventId(boolean isAccepted, Long id);

    List<Offer> findAllByIsOfferAcceptedAndService_ServiceId(boolean isAccepted, Long id);

}
