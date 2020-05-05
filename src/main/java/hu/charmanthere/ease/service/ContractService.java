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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.List;

@Service
public class ContractService {
    public ContractDaoImpl contractDao;
    public EventDaoImpl eventDao;
    public ServiceDaoImpl serviceDao;

    @Value("${fixer.io.key}")
    public String fixerKey;

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

    public String getExchangeRateToday(){
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://data.fixer.io/api/latest?access_key="+fixerKey;
        String result = restTemplate.getForObject(uri, String.class);
        JsonReader jsonReader = Json.createReader(new StringReader(result));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();

        System.out.println(jsonObject.getString("base"));
        JsonObject rates = jsonObject.getJsonObject("rates");
        System.out.println("One euro is "+rates.getJsonNumber("HUF").toString() + " forint today.");


        System.out.println(result);
        return result;
    }
}
