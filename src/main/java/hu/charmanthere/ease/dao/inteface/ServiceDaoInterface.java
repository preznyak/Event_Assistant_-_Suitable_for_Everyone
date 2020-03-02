package hu.charmanthere.ease.dao.inteface;

import hu.charmanthere.ease.dao.entity.Service;
import hu.charmanthere.ease.dao.enumeration.ServiceCategory;
import hu.charmanthere.ease.exception.ServiceWithIdDoesNotExistException;

import java.util.List;

public interface ServiceDaoInterface {
    public List<Service> findServicesByCategory(ServiceCategory category);
    public List<Service> findServicesByLocality(String locality);
    public hu.charmanthere.ease.dao.entity.Service findById(Long id) throws ServiceWithIdDoesNotExistException;
    public void rateServiceById(Long id, int rating) throws ServiceWithIdDoesNotExistException;
}
