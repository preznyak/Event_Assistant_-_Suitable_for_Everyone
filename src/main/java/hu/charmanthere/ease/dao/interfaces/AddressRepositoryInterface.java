package hu.charmanthere.ease.dao.interfaces;

import hu.charmanthere.ease.dao.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositoryInterface extends JpaRepository<Address, Long> {
}
