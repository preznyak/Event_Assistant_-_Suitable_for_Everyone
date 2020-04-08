package hu.charmanthere.ease.service.converter;

import hu.charmanthere.ease.controller.model.contact.ContactModel;
import hu.charmanthere.ease.dao.entity.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactModelConverter {

    private ModelMapper modelMapper;

    @Autowired
    public ContactModelConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Contact fromContactModel(ContactModel contactModel){
        return modelMapper.map(contactModel,Contact.class);
    }

    public ContactModel fromContact(Contact contact){
        return modelMapper.map(contact, ContactModel.class);
    }
}
