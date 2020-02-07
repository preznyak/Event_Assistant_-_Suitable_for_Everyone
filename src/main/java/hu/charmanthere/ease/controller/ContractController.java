package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entity.Contract;
import hu.charmanthere.ease.exception.ContractWithIdDoesNotExistException;
import hu.charmanthere.ease.dao.implementation.ContractDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contract")
public class ContractController {
    private ContractDaoImpl contractDaoImpl;

    @Autowired
    public ContractController(ContractDaoImpl contractDaoImpl) {
        this.contractDaoImpl = contractDaoImpl;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{contractId}")
    public ResponseEntity<?> deleteContractByContractId(@PathVariable Long contractId) {
        contractDaoImpl.deleteById(contractId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createContract(@RequestBody Contract contract) {
        contractDaoImpl.save(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllContract() {
        return new ResponseEntity<>(contractDaoImpl.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/{id}")
    public ResponseEntity<?> findAllContract(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(contractDaoImpl.findById(id), HttpStatus.OK);
        } catch (ContractWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{contractId}")
    public ResponseEntity<?> updateContractById(@PathVariable Long contractId, @RequestBody Contract contract) {
        try {
            contractDaoImpl.update(contractId,contract);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ContractWithIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
