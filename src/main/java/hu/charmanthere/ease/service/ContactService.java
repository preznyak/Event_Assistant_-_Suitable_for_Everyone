package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.Contact;
import hu.charmanthere.ease.dao.implementation.ContactDaoImpl;
import hu.charmanthere.ease.exception.ContactWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactService {
    public ContactDaoImpl contactDao;

    @Autowired
    public ContactService(ContactDaoImpl contactDao) {
        this.contactDao = contactDao;
    }

    public List<Contact> findAllContact() {
        return contactDao.findAll();
    }

    public Contact findById(Long id) throws ContactWithIdDoesNotExistException {
        return contactDao.findById(id);
    }

    public void createContact(Contact contact) {
        contactDao.save(contact);
    }

    public void update(Long id, Contact contact) throws ContactWithIdDoesNotExistException {
        contactDao.update(id,contact);
    }

    public void deleteById(Long id) {
        contactDao.deleteById(id);
    }
}
