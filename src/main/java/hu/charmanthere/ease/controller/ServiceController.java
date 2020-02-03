package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entities.Service;
import hu.charmanthere.ease.dao.entities.User;
import hu.charmanthere.ease.dao.interfaces.ServiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    private ServiceRepositoryInterface serviceRepositoryInterface;

    @Autowired
    public ServiceController(ServiceRepositoryInterface serviceRepositoryInterface) {
        this.serviceRepositoryInterface = serviceRepositoryInterface;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{serviceId}")
    public ResponseEntity<?> deleteServiceByServiceId(@PathVariable Long serviceId) {
        serviceRepositoryInterface.deleteById(serviceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createService(@RequestBody Service service) {
        serviceRepositoryInterface.save(service);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllService() {
        return new ResponseEntity<>(serviceRepositoryInterface.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{serviceId}")
    public ResponseEntity<?> updateServiceById(@PathVariable Long serviceId,@RequestBody Service service) {
        Service serviceToBeUpdated = serviceRepositoryInterface.findById(serviceId).orElse(null);
        if(serviceToBeUpdated == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        serviceToBeUpdated.setAddresses(service.getAddresses());
        serviceToBeUpdated.setContacts(service.getContacts());
        serviceToBeUpdated.setDescription(service.getDescription());
        serviceToBeUpdated.setHomePage(service.getHomePage());
        serviceToBeUpdated.setName(service.getName());
        serviceToBeUpdated.setServiceCategory(service.getServiceCategory());
        serviceRepositoryInterface.save(serviceToBeUpdated);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
