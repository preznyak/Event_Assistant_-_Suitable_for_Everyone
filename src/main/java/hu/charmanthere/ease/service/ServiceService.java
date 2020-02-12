package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.Service;
import hu.charmanthere.ease.dao.enumeration.ServiceCategory;
import hu.charmanthere.ease.dao.implementation.ServiceDaoImpl;
import hu.charmanthere.ease.exception.ServiceWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    public ServiceDaoImpl serviceDao;

    @Autowired
    public ServiceService(ServiceDaoImpl serviceDao) {
        this.serviceDao = serviceDao;
    }

    public List<Service> findAllService() {
        return serviceDao.findAll();
    }

    public void createService(Service service) {
        serviceDao.create(service);
    }

    public void update(Long id, Service service) throws ServiceWithIdDoesNotExistException {
        serviceDao.updateById(id,service);
    }

    public void deleteById(Long id) {
        serviceDao.deleteById(id);
    }

    public List<Service> findServicesByCategory(ServiceCategory category){
        return serviceDao.findServicesByCategory(category);
    }

    public List<Service> findServicesByLocality(String locality){
        return serviceDao.findServicesByLocality(locality);
    }
}
