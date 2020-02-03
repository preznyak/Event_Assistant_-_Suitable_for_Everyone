package hu.charmanthere.ease.dao.interfaces;

import hu.charmanthere.ease.dao.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepositoryInterface extends JpaRepository<Contract, Long> {
}
