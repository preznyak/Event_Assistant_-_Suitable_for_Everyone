package hu.charmanthere.ease.dao.implementation;

import hu.charmanthere.ease.dao.entity.Contact;
import hu.charmanthere.ease.dao.inteface.ContactDaoInterface;
import hu.charmanthere.ease.dao.repository.ContactRepositoryInterface;
import hu.charmanthere.ease.exception.ContactWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactDaoImpl implements ContactDaoInterface {

    private ContactRepositoryInterface contactRepositoryInterface;

    @Autowired
    public ContactDaoImpl(ContactRepositoryInterface contactRepositoryInterface) {
        this.contactRepositoryInterface = contactRepositoryInterface;
    }

    public List<Contact> findAll() {
        return contactRepositoryInterface.findAll();
    }

    public Contact findById(Long id) throws ContactWithIdDoesNotExistException {
        Contact contact = contactRepositoryInterface.findById(id).orElse(null);
        if(contact == null){
            System.out.println("Contact with "+ id + " does not exist!");
            throw new ContactWithIdDoesNotExistException("Contact with "+ id + " does not exist!");
        }
        return contact;
    }

    public void save(Contact contact) {
        contactRepositoryInterface.save(contact);
    }

    public void update(Long id, Contact contact) throws ContactWithIdDoesNotExistException {
        Contact contactToBeUpdated = contactRepositoryInterface.findById(id).orElse(null);
        if(contactToBeUpdated == null){
            System.out.println("Contact with "+ id + " does not exist!");
            throw new ContactWithIdDoesNotExistException("Contact with "+ id + " does not exist!");
        }
        contactToBeUpdated.setEmail(contact.getEmail());
        contactToBeUpdated.setName(contact.getName());
        contactToBeUpdated.setFacebookLink(contact.getFacebookLink());
        contactToBeUpdated.setPhoneNumber(contact.getPhoneNumber());
        contactRepositoryInterface.save(contactToBeUpdated);
    }

    public void deleteById(Long contactId) {
        contactRepositoryInterface.deleteById(contactId);
    }
}
