package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.Service;
import hu.charmanthere.ease.dao.enumeration.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepositoryInterface extends JpaRepository<Service, Long> {
    public List<Service> findServiceByServiceCategory(ServiceCategory category);
    public List<Service> findServiceByAddresses_City(String city);
    public List<Service> findServiceByUser_UserId(Long id);
}
