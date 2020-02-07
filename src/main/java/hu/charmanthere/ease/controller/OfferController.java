package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entity.Offer;
import hu.charmanthere.ease.exception.OfferWithIdDoesNotExistException;
import hu.charmanthere.ease.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/offer")
public class OfferController {
    private OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{offerId}")
    public ResponseEntity<?> deleteOfferByOfferId(@PathVariable Long offerId) {
        offerService.deleteById(offerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createOffer(@RequestBody Offer Offer) {
        offerService.createOffer(Offer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllOffer() {
        return new ResponseEntity<>(offerService.findAllOffer(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{OfferId}")
    public ResponseEntity<?> updateOfferById(@PathVariable Long OfferId, @RequestBody Offer offer) {
        try {
            offerService.update(OfferId,offer);
        } catch (OfferWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
