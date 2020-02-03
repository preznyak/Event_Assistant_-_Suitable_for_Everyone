package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entities.Contact;
import hu.charmanthere.ease.dao.interfaces.ContactRepositoryInterface;
import hu.charmanthere.ease.exception.ContactWithIdDoesNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ContactService {

    private ContactRepositoryInterface contactRepositoryInterface;

    @Autowired
    public ContactService(ContactRepositoryInterface contactRepositoryInterface) {
        this.contactRepositoryInterface = contactRepositoryInterface;
    }

    public List<Contact> findAll() {
        return contactRepositoryInterface.findAll();
    }

    public Contact findById(Long id) throws ContactWithIdDoesNotExist {
        Contact contact = contactRepositoryInterface.findById(id).orElse(null);
        if(contact == null){
            System.out.println("Contact with "+ id + " does not exist!");
            throw new ContactWithIdDoesNotExist("Contact with "+ id + " does not exist!");
        }
        return contact;
    }

    public void save(Contact contact) {
        contactRepositoryInterface.save(contact);
    }

    public void update(Long id, Contact contact) throws ContactWithIdDoesNotExist {
        Contact contactToBeUpdated = contactRepositoryInterface.findById(id).orElse(null);
        if(contact == null){
            System.out.println("Contact with "+ id + " does not exist!");
            throw new ContactWithIdDoesNotExist("Contact with "+ id + " does not exist!");
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
