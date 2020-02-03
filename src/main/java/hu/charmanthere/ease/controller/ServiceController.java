package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entities.Service;
import hu.charmanthere.ease.dao.entities.User;
import hu.charmanthere.ease.dao.interfaces.ServiceRepositoryInterface;
import hu.charmanthere.ease.exception.ServiceWithIdDoesNotExistException;
import hu.charmanthere.ease.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        serviceService.create(service);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllService() {
        return new ResponseEntity<>(serviceService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{serviceId}")
    public ResponseEntity<?> updateServiceById(@PathVariable Long serviceId,@RequestBody Service service) {
        try {
            serviceService.updateById(serviceId,service);
        } catch (ServiceWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
