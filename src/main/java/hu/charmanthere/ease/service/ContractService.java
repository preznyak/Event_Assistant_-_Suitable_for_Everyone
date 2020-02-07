package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.Contract;
import hu.charmanthere.ease.dao.implementation.ContractDaoImpl;
import hu.charmanthere.ease.exception.ContractWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractService {
    public ContractDaoImpl contractDao;

    @Autowired
    public ContractService(ContractDaoImpl contractDao) {
        this.contractDao = contractDao;
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
}
