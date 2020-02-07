package hu.charmanthere.ease.dao.implementation;

import hu.charmanthere.ease.dao.inteface.ServiceDaoInterface;
import hu.charmanthere.ease.dao.repository.ServiceRepositoryInterface;
import hu.charmanthere.ease.exception.ServiceWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDaoImpl implements ServiceDaoInterface {

    private ServiceRepositoryInterface serviceRepositoryInterface;

    @Autowired
    public ServiceDaoImpl(ServiceRepositoryInterface serviceRepositoryInterface) {
        this.serviceRepositoryInterface = serviceRepositoryInterface;
    }

    public void deleteById(Long id){
        serviceRepositoryInterface.deleteById(id);
    }

    public void create(hu.charmanthere.ease.dao.entity.Service service){
        serviceRepositoryInterface.save(service);
    }

    public List<hu.charmanthere.ease.dao.entity.Service> findAll(){
        return serviceRepositoryInterface.findAll();
    }

    public void updateById(Long id, hu.charmanthere.ease.dao.entity.Service service) throws ServiceWithIdDoesNotExistException {
        hu.charmanthere.ease.dao.entity.Service serviceToBeUpdated = serviceRepositoryInterface.findById(id).orElse(null);
        if(serviceToBeUpdated == null){
            System.out.println("Service with id: " + id + " does not exist.");
            throw new ServiceWithIdDoesNotExistException("Service with id: " + id + " does not exist.");
        }
        serviceToBeUpdated.setAddresses(service.getAddresses());
        serviceToBeUpdated.setContacts(service.getContacts());
        serviceToBeUpdated.setDescription(service.getDescription());
        serviceToBeUpdated.setHomePage(service.getHomePage());
        serviceToBeUpdated.setName(service.getName());
        serviceToBeUpdated.setServiceCategory(service.getServiceCategory());
        serviceRepositoryInterface.save(serviceToBeUpdated);
    }
}