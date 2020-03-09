package hu.charmanthere.ease.dao.inteface;

import hu.charmanthere.ease.dao.entity.Contract;
import hu.charmanthere.ease.dao.entity.Service;
import hu.charmanthere.ease.dao.enumeration.ServiceCategory;
import hu.charmanthere.ease.exception.ServiceWithIdDoesNotExistException;

import java.util.Date;
import java.util.List;

public interface ServiceDaoInterface {
    List<Service> findServicesByCategory(ServiceCategory category);
    List<Service> findServicesByLocality(String locality);
    hu.charmanthere.ease.dao.entity.Service findById(Long id) throws ServiceWithIdDoesNotExistException;
    void rateServiceById(Long id, int rating) throws ServiceWithIdDoesNotExistException;

    List<Contract> getContractsByServiceId(Long id);
}
