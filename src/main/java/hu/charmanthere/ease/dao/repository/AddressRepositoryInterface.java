package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositoryInterface extends JpaRepository<Address, Long> {
}
