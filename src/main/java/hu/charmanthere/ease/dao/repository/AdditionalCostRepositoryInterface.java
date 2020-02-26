package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.AdditionalCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalCostRepositoryInterface extends JpaRepository<AdditionalCost,Long> {
}
