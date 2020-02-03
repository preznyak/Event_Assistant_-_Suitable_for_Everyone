package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entities.Contact;
import hu.charmanthere.ease.dao.entities.Contract;
import hu.charmanthere.ease.dao.interfaces.ContractRepositoryInterface;
import hu.charmanthere.ease.exception.ContactWithIdDoesNotExistException;
import hu.charmanthere.ease.exception.ContractWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    private ContractRepositoryInterface contractRepositoryInterface;

    @Autowired
    public ContractService(ContractRepositoryInterface contractRepositoryInterface) {
        this.contractRepositoryInterface = contractRepositoryInterface;
    }

    public List<Contract> findAll() {
        return contractRepositoryInterface.findAll();
    }

    public Contract findById(Long id) throws ContractWithIdDoesNotExistException {
        Contract contract = contractRepositoryInterface.findById(id).orElse(null);
        if(contract == null){
            System.out.println("Contract with "+ id + " does not exist!");
            throw new ContractWithIdDoesNotExistException("Contract with "+ id + " does not exist!");
        }
        return contract;
    }

    public void save(Contract contract) {
        contractRepositoryInterface.save(contract);
    }

    public void update(Long id, Contract contract) throws ContractWithIdDoesNotExistException {
        Contract contractToBeUpdated = contractRepositoryInterface.findById(id).orElse(null);
        if(contract == null){
            System.out.println("Contact with "+ id + " does not exist!");
            throw new ContractWithIdDoesNotExistException("Contact with "+ id + " does not exist!");
        }
        contractToBeUpdated.setDeposit(contract.getDeposit());
        contractToBeUpdated.setDepositPayed(contract.getDepositPayed());
        contractToBeUpdated.setDepositPaymentTime(contract.getDepositPaymentTime());
        contractToBeUpdated.setDescription(contract.getDescription());
        contractToBeUpdated.setPaymentMethod(contract.getPaymentMethod());
        contractToBeUpdated.setPrice(contract.getPrice());
        contractToBeUpdated.setPricePayed(contract.getPricePayed());
        contractToBeUpdated.setPricePaymentTime(contract.getPricePaymentTime());
        contractRepositoryInterface.save(contractToBeUpdated);
        contractRepositoryInterface.save(contractToBeUpdated);
    }

    public void deleteById(Long contractId) {
        contractRepositoryInterface.deleteById(contractId);
    }
}
