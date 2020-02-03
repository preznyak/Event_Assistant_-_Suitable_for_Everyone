package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entities.Contract;
import hu.charmanthere.ease.dao.interfaces.ContractRepositoryInterface;
import hu.charmanthere.ease.exception.ContactWithIdDoesNotExistException;
import hu.charmanthere.ease.exception.ContractWithIdDoesNotExistException;
import hu.charmanthere.ease.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contract")
public class ContractController {
    private ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{contractId}")
    public ResponseEntity<?> deleteContractByContractId(@PathVariable Long contractId) {
        contractService.deleteById(contractId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createContract(@RequestBody Contract contract) {
        contractService.save(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllContract() {
        return new ResponseEntity<>(contractService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/{id}")
    public ResponseEntity<?> findAllContract(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(contractService.findById(id), HttpStatus.OK);
        } catch (ContractWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{contractId}")
    public ResponseEntity<?> updateContractById(@PathVariable Long contractId, @RequestBody Contract contract) {
        try {
            contractService.update(contractId,contract);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ContractWithIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
