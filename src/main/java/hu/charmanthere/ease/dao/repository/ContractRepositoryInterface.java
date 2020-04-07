package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepositoryInterface extends JpaRepository<Contract, Long> {
    List<Contract> findAllByService_ServiceId(Long serviceId);
}
