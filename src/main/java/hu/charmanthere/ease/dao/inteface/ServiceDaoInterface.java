package hu.charmanthere.ease.dao.inteface;

import hu.charmanthere.ease.dao.entity.Service;
import hu.charmanthere.ease.dao.enumeration.ServiceCategory;

import java.util.List;

public interface ServiceDaoInterface {
    public List<Service> findServicesByCategory(ServiceCategory category);
    public List<Service> findServicesByLocality(String locality);
}
