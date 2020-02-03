package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entities.Address;
import hu.charmanthere.ease.dao.interfaces.AddressRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private AddressRepositoryInterface addressRepositoryInterface;

    @Autowired
    public AddressController(AddressRepositoryInterface addressRepositoryInterface) {
        this.addressRepositoryInterface = addressRepositoryInterface;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllAddress() {
        return new ResponseEntity<>(addressRepositoryInterface.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
        addressRepositoryInterface.save(address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> updateAddressById(@PathVariable Long id, @RequestBody Address address) {
        Address addressToBeUpdated = addressRepositoryInterface.findById(id).orElse(null);
        if(addressToBeUpdated == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        addressToBeUpdated.setCity(address.getCity());
        addressToBeUpdated.setCountry(address.getCountry());
        addressToBeUpdated.setHouseNumber(address.getHouseNumber());
        addressToBeUpdated.setState(address.getState());
        addressToBeUpdated.setStreetName(address.getStreetName());
        addressToBeUpdated.setZipCode(address.getZipCode());
        addressRepositoryInterface.save(addressToBeUpdated);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{addressId}")
    public ResponseEntity<?> deleteAddressByUserId(@PathVariable Long addressId) {
        addressRepositoryInterface.deleteById(addressId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
