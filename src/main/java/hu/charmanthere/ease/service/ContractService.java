package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.Contract;
import hu.charmanthere.ease.dao.entity.Event;
import hu.charmanthere.ease.dao.implementation.ContractDaoImpl;
import hu.charmanthere.ease.dao.implementation.EventDaoImpl;
import hu.charmanthere.ease.dao.implementation.ServiceDaoImpl;
import hu.charmanthere.ease.exception.ContractWithIdDoesNotExistException;
import hu.charmanthere.ease.exception.EventWithIdDoesNotExistException;
import hu.charmanthere.ease.exception.ServiceWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ContractService {
    public ContractDaoImpl contractDao;
    public EventDaoImpl eventDao;
    public ServiceDaoImpl serviceDao;

    @Autowired
    public ContractService(ContractDaoImpl contractDao, EventDaoImpl eventDao, ServiceDaoImpl serviceDao) {
        this.contractDao = contractDao;
        this.eventDao = eventDao;
        this.serviceDao = serviceDao;
    }

    public List<Contract> findAllContract() {
        return contractDao.findAll();
    }

    public Contract findById(Long id) throws ContractWithIdDoesNotExistException {
        return contractDao.findById(id);
    }

    public void createContract(Contract contract) {
        contractDao.save(contract);
    }

    public void update(Long id, Contract contract) throws ContractWithIdDoesNotExistException {
        contractDao.update(id,contract);
    }

    public void deleteById(Long id) {
        contractDao.deleteById(id);
    }

    public List<Contract> findAllByEventId(Long eventId) throws EventWithIdDoesNotExistException {
        Event event = eventDao.findById(eventId);
        return contractDao.findAllByEvent(event);
    }
    public List<Contract> findAllByServiceId(Long serviceId) throws ServiceWithIdDoesNotExistException {
        hu.charmanthere.ease.dao.entity.Service service = serviceDao.findById(serviceId);
        return contractDao.findAllByService(service);
    }
}
