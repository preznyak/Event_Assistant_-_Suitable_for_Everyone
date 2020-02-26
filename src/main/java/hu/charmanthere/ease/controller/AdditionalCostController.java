package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entity.AdditionalCost;
import hu.charmanthere.ease.exception.AdditionalCostWithIdDoesNotExistException;
import hu.charmanthere.ease.service.AdditionalCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/additionalcost")
public class AdditionalCostController {

    private AdditionalCostService additionalCostService;

    @Autowired
    public AdditionalCostController(AdditionalCostService additionalCostService) {
        this.additionalCostService = additionalCostService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllAdditionalCost() {
        return new ResponseEntity<>(additionalCostService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(additionalCostService.findById(id), HttpStatus.OK);
        } catch (AdditionalCostWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createAdditionalCost(@RequestBody AdditionalCost additionalCost) {
        additionalCostService.save(additionalCost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> updateAdditionalCostById(@PathVariable Long id, @RequestBody AdditionalCost additionalCost) {
        try {
            additionalCostService.update(id, additionalCost);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AdditionalCostWithIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
    public ResponseEntity<?> deleteAdditionalCostById(@PathVariable Long id) {
        additionalCostService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
