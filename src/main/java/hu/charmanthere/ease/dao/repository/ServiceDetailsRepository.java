package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.ServiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDetailsRepository extends JpaRepository<ServiceDetails, Long> {
}
