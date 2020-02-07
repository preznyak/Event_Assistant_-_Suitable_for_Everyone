package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entity.Address;
import hu.charmanthere.ease.exception.AddressWithIdDoesNotExistException;
import hu.charmanthere.ease.dao.implementation.AddressDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private AddressDaoImpl addressDaoImpl;

    @Autowired
    public AddressController(AddressDaoImpl addressDaoImpl) {
        this.addressDaoImpl = addressDaoImpl;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllAddress() {
        return new ResponseEntity<>(addressDaoImpl.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(addressDaoImpl.findById(id), HttpStatus.OK);
        } catch (AddressWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
        addressDaoImpl.save(address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> updateAddressById(@PathVariable Long id, @RequestBody Address address) {
        try {
            addressDaoImpl.update(id, address);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AddressWithIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{addressId}")
    public ResponseEntity<?> deleteAddressByUserId(@PathVariable Long addressId) {
        addressDaoImpl.deleteById(addressId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
