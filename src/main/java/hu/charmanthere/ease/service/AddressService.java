package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entities.Address;
import hu.charmanthere.ease.dao.interfaces.AddressRepositoryInterface;
import hu.charmanthere.ease.exception.AddressWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {


    private AddressRepositoryInterface addressRepositoryInterface;

    @Autowired
    public AddressService(AddressRepositoryInterface addressRepositoryInterface) {
        this.addressRepositoryInterface = addressRepositoryInterface;
    }

    public List<Address> findAll() {
        return addressRepositoryInterface.findAll();
    }

    public Address findById(Long id) throws AddressWithIdDoesNotExistException {
        Address address = addressRepositoryInterface.findById(id).orElse(null);
        if(address == null){
            //TODO logger
            System.out.println("Address with " + id + " does not exist!");
            throw new AddressWithIdDoesNotExistException("Address with " + id + " does not exist!");
        }
        return address;
    }

    public void save(Address address) {
        addressRepositoryInterface.save(address);
    }

    public void update(Long id, Address address) throws AddressWithIdDoesNotExistException {
        Address addressToBeUpdated = addressRepositoryInterface.findById(id).orElse(null);
        if(addressToBeUpdated == null){
            //TODO logger
            System.out.println("Address with " + id + " does not exist!");
            throw new AddressWithIdDoesNotExistException("Address with " + id + " does not exist!");
        }
        addressToBeUpdated.setCity(address.getCity());
        addressToBeUpdated.setCountry(address.getCountry());
        addressToBeUpdated.setHouseNumber(address.getHouseNumber());
        addressToBeUpdated.setState(address.getState());
        addressToBeUpdated.setStreetName(address.getStreetName());
        addressToBeUpdated.setZipCode(address.getZipCode());
        addressRepositoryInterface.save(addressToBeUpdated);
    }

    public void deleteById(Long addressId) {
        addressRepositoryInterface.deleteById(addressId);
    }
}
