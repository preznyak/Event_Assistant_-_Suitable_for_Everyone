package hu.charmanthere.ease.dao.implementation;

import hu.charmanthere.ease.dao.entity.Offer;
import hu.charmanthere.ease.dao.inteface.OfferDaoInterface;
import hu.charmanthere.ease.dao.repository.OfferRepositoryInterface;
import hu.charmanthere.ease.exception.OfferWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferDaoImpl implements OfferDaoInterface {

    private OfferRepositoryInterface offerRepositoryInterface;

    @Autowired
    public OfferDaoImpl(OfferRepositoryInterface offerRepositoryInterface) {
        this.offerRepositoryInterface = offerRepositoryInterface;
    }

    public void create(Offer offer){
        offerRepositoryInterface.save(offer);
    }

    public void updateById(Long id, Offer offer) throws OfferWithIdDoesNotExistException {
        Offer offerToBeUpdated = offerRepositoryInterface.findById(id).orElse(null);
        if (offerToBeUpdated == null) {
            System.out.println("Offer with id: " + id + " dooes not exist.");
            throw new OfferWithIdDoesNotExistException("Offer with id: " + id + " dooes not exist.");
        }
        offerToBeUpdated.setDeposit(offer.getDeposit());
        offerToBeUpdated.setDepositPaymentTime(offer.getDepositPaymentTime());
        offerToBeUpdated.setDescription(offer.getDescription());
        offerToBeUpdated.setOfferAccepted(offer.getOfferAccepted());
        offerToBeUpdated.setPaymentMethod(offer.getPaymentMethod());
        offerToBeUpdated.setPrice(offer.getPrice());
        offerToBeUpdated.setPricePaymentTime(offer.getPricePaymentTime());
        offerRepositoryInterface.save(offerToBeUpdated);
    }

    public List<Offer> findAll(){
        return offerRepositoryInterface.findAll();
    }

    public void deleteById(Long id){
        offerRepositoryInterface.deleteById(id);
    }

    @Override
    public List<Offer> findAllByService_ServiceId(Long id) {
        return offerRepositoryInterface.findAllByService_ServiceId(id);
    }

    @Override
    public List<Offer> findAllByEvent_EventId(Long id) {
        return offerRepositoryInterface.findAllByEvent_EventId(id);
    }

    @Override
    public List<Offer> findAllByIsOfferAcceptedAndEvent_EventId(boolean isAccepted, Long id) {
        return offerRepositoryInterface.findAllByIsOfferAcceptedAndEvent_EventId(isAccepted, id);
    }

    @Override
    public List<Offer> findAllByIsOfferAcceptedAndService_ServiceId(boolean isAccepted, Long id) {
        return offerRepositoryInterface.findAllByIsOfferAcceptedAndService_ServiceId(isAccepted, id);
    }
}
