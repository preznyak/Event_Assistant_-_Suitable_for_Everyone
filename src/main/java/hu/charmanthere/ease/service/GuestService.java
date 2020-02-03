package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entities.Guest;
import hu.charmanthere.ease.dao.interfaces.GuestRepositoryInterface;
import hu.charmanthere.ease.exception.GuestWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private GuestRepositoryInterface guestRepositoryInterface;

    @Autowired
    public GuestService(GuestRepositoryInterface guestRepositoryInterface) {
        this.guestRepositoryInterface = guestRepositoryInterface;
    }

    public void create(Guest guest){
        guestRepositoryInterface.save(guest);
    }

    public void updateById(Long id, Guest guest) throws GuestWithIdDoesNotExistException {
        Guest guestToBeUpdated = guestRepositoryInterface.findById(id).orElse(null);
        if (guestToBeUpdated == null) {
            System.out.println("Guest with id: " + id + " dooes not exist.");
            throw new GuestWithIdDoesNotExistException("Guest with id: " + id + " dooes not exist.");
        }
        guestToBeUpdated.setContact(guest.getContact());
        guestToBeUpdated.setFirstName(guest.getFirstName());
        guestToBeUpdated.setLastName(guest.getFirstName());
        guestToBeUpdated.setInvitationAccepted(guestToBeUpdated.getInvitationAccepted());
        guestRepositoryInterface.save(guestToBeUpdated);
    }

    public List<Guest> findAll(){
        return guestRepositoryInterface.findAll();
    }

    public void deleteById(Long id){
        guestRepositoryInterface.deleteById(id);
    }
}
