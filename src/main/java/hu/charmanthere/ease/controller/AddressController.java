package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entity.Address;
import hu.charmanthere.ease.exception.AddressWithIdDoesNotExistException;
import hu.charmanthere.ease.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllAddress() {
        return new ResponseEntity<>(addressService.findAllAddress(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(addressService.findById(id), HttpStatus.OK);
        } catch (AddressWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> updateAddressById(@PathVariable Long id, @RequestBody Address address) {
        try {
            addressService.update(id, address);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AddressWithIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{addressId}")
    public ResponseEntity<?> deleteAddressByUserId(@PathVariable Long addressId) {
        addressService.deleteById(addressId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
