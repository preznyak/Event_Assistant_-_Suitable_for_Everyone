package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entities.Contract;
import hu.charmanthere.ease.dao.interfaces.ContractRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contract")
public class ContractController {
    private ContractRepositoryInterface contractRepositoryInterface;

    @Autowired
    public ContractController(ContractRepositoryInterface contractRepositoryInterface) {
        this.contractRepositoryInterface = contractRepositoryInterface;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{contractId}")
    public ResponseEntity<?> deleteContractByContractId(@PathVariable Long contractId) {
        contractRepositoryInterface.deleteById(contractId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createContract(@RequestBody Contract contract) {
        contractRepositoryInterface.save(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllContract() {
        return new ResponseEntity<>(contractRepositoryInterface.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{contractId}")
    public ResponseEntity<?> updateContractById(@PathVariable Long contractId, @RequestBody Contract contract) {
        Contract contractToBeUpdated = contractRepositoryInterface.findById(contractId).orElse(null);
        if (contractToBeUpdated == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
