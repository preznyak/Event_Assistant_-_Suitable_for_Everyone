package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepositoryInterface extends JpaRepository<Contact, Long> {

}
