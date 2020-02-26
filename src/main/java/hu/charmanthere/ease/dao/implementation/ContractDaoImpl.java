package hu.charmanthere.ease.dao.implementation;

import hu.charmanthere.ease.dao.entity.Contract;
import hu.charmanthere.ease.dao.inteface.ContractDaoInterface;
import hu.charmanthere.ease.dao.repository.ContractRepositoryInterface;
import hu.charmanthere.ease.exception.ContractWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDaoImpl implements ContractDaoInterface {
    private ContractRepositoryInterface contractRepositoryInterface;

    @Autowired
    public ContractDaoImpl(ContractRepositoryInterface contractRepositoryInterface) {
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
        if(contractToBeUpdated == null){
            System.out.println("Contract with "+ id + " does not exist!");
            throw new ContractWithIdDoesNotExistException("Contract with "+ id + " does not exist!");
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
    }

    public void deleteById(Long contractId) {
        contractRepositoryInterface.deleteById(contractId);
    }
}
