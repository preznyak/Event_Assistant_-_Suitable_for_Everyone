package hu.charmanthere.ease.dao.inteface;

import hu.charmanthere.ease.dao.entity.Offer;

import java.util.List;

public interface OfferDaoInterface {

    List<Offer> findAllByService_ServiceId(Long id);

    List<Offer> findAllByEvent_EventId(Long id);

    List<Offer> findAllByIsOfferAcceptedAndEvent_EventId(boolean isAccepted, Long id);

    List<Offer> findAllByIsOfferAcceptedAndService_ServiceId(boolean isAccepted, Long id);

}
