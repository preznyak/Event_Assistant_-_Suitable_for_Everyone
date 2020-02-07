package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.Guest;
import hu.charmanthere.ease.dao.implementation.GuestDaoImpl;
import hu.charmanthere.ease.exception.GuestWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    public GuestDaoImpl guestDao;

    @Autowired
    public GuestService(GuestDaoImpl guestDao) {
        this.guestDao = guestDao;
    }

    public List<Guest> findAllGuest() {
        return guestDao.findAll();
    }

    public void createGuest(Guest guest) {
        guestDao.create(guest);
    }

    public void update(Long id, Guest guest) throws GuestWithIdDoesNotExistException {
        guestDao.updateById(id,guest);
    }

    public void deleteById(Long id) {
        guestDao.deleteById(id);
    }
}
