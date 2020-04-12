package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.Offer;
import hu.charmanthere.ease.dao.implementation.OfferDaoImpl;
import hu.charmanthere.ease.exception.OfferWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    public OfferDaoImpl offerDao;

    @Autowired
    public OfferService(OfferDaoImpl offerDao) {
        this.offerDao = offerDao;
    }

    public List<Offer> findAllOffer() {
        return offerDao.findAll();
    }

    public void createOffer(Offer offer) {
        offerDao.create(offer);
    }

    public void update(Long id, Offer offer) throws OfferWithIdDoesNotExistException {
        offerDao.updateById(id,offer);
    }

    public void deleteById(Long id) {
        offerDao.deleteById(id);
    }

    public List<Offer> findAllByService_ServiceId(Long id){
        return offerDao.findAllByService_ServiceId(id);
    }

    public List<Offer> findAllByEvent_EventId(Long id){
        return offerDao.findAllByEvent_EventId(id);
    }

    public List<Offer> findAllByIsOfferAcceptedAndEvent_EventId(boolean isAccepted, Long id){
        return offerDao.findAllByIsOfferAcceptedAndEvent_EventId(isAccepted, id);
    }

    public List<Offer> findAllByIsOfferAcceptedAndService_ServiceId(boolean isAccepted, Long id){
        return offerDao.findAllByIsOfferAcceptedAndService_ServiceId(isAccepted, id);
    }
}
