package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.Address;
import hu.charmanthere.ease.dao.implementation.AddressDaoImpl;
import hu.charmanthere.ease.exception.AddressWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    public AddressDaoImpl addressDao;

    @Autowired
    public AddressService(AddressDaoImpl addressDao) {
        this.addressDao = addressDao;
    }

    public List<Address> findAllAddress() {
        return addressDao.findAll();
    }

    public Address findById(Long id) throws AddressWithIdDoesNotExistException {
        return addressDao.findById(id);
    }

    public void createAddress(Address address) {
        addressDao.save(address);
    }

    public void update(Long id, Address address) throws AddressWithIdDoesNotExistException {
        addressDao.update(id,address);
    }

    public void deleteById(Long id) {
        addressDao.deleteById(id);
    }
}
