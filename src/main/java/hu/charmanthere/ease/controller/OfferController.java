package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entities.Offer;
import hu.charmanthere.ease.dao.interfaces.OfferRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/offer")
public class OfferController {
    private OfferRepositoryInterface offerRepositoryInterface;

    @Autowired
    public OfferController(OfferRepositoryInterface offerRepositoryInterface) {
        this.offerRepositoryInterface = offerRepositoryInterface;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{offerId}")
    public ResponseEntity<?> deleteOfferByOfferId(@PathVariable Long offerId) {
        offerRepositoryInterface.deleteById(offerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createOffer(@RequestBody Offer Offer) {
        offerRepositoryInterface.save(Offer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllOffer() {
        return new ResponseEntity<>(offerRepositoryInterface.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{OfferId}")
    public ResponseEntity<?> updateOfferById(@PathVariable Long OfferId, @RequestBody Offer offer) {
        Offer offerToBeUpdated = offerRepositoryInterface.findById(OfferId).orElse(null);
        if (offerToBeUpdated == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        offerToBeUpdated.setDeposit(offer.getDeposit());
        offerToBeUpdated.setDepositPaymentTime(offer.getDepositPaymentTime());
        offerToBeUpdated.setDescription(offer.getDescription());
        offerToBeUpdated.setOfferAccepted(offer.getOfferAccepted());
        offerToBeUpdated.setPaymentMethod(offer.getPaymentMethod());
        offerToBeUpdated.setPrice(offer.getPrice());
        offerToBeUpdated.setPricePaymentTime(offer.getPricePaymentTime());
        offerRepositoryInterface.save(offerToBeUpdated);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
