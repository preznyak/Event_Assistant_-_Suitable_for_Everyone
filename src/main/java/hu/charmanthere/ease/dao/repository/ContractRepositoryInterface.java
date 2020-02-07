package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepositoryInterface extends JpaRepository<Contract, Long> {
}
