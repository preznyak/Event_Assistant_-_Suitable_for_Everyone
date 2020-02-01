package hu.charmanthere.ease.dao.interfaces;

import hu.charmanthere.ease.dao.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepositoryInterface extends JpaRepository<Contact, Long> {

}
