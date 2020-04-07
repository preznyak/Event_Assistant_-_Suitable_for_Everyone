package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entity.Contract;
import hu.charmanthere.ease.dao.entity.Service;
import hu.charmanthere.ease.dao.enumeration.ServiceCategory;
import hu.charmanthere.ease.exception.ServiceWithIdDoesNotExistException;
import hu.charmanthere.ease.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    private ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{serviceId}")
    public ResponseEntity<?> deleteServiceByServiceId(@PathVariable Long serviceId) {
        serviceService.deleteById(serviceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createService(@RequestBody Service service) {
        serviceService.createService(service);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllService() {
        return new ResponseEntity<>(serviceService.findAllService(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{serviceId}")
    public ResponseEntity<?> updateServiceById(@PathVariable Long serviceId,@RequestBody Service service) {
        try {
            serviceService.update(serviceId,service);
        } catch (ServiceWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/category/{category}")
    public ResponseEntity<?> findServicesByCategory(@PathVariable ServiceCategory category) {
        return new ResponseEntity<>(serviceService.findServicesByCategory(category), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/locality/{locality}")
    public ResponseEntity<?> findServicesByLocality(@PathVariable String locality) {
        return new ResponseEntity<>(serviceService.findServicesByLocality(locality), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/{id}")
    public ResponseEntity<?> findServiceById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(serviceService.findById(id), HttpStatus.OK);
        } catch (ServiceWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/rate/{id}")
    public ResponseEntity<?> rateServiceById(@PathVariable Long id, @RequestBody int rating){
        try {
            serviceService.rateServiceById(id, rating);
        } catch (ServiceWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/calendar/{id}")
    public ResponseEntity<?> getCalendarByServiceId(@PathVariable Long id){
        List<Contract> contracts = serviceService.getContractsByServiceId(id);
        return new ResponseEntity<>(contracts, HttpStatus.OK);

    }
}
