package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.AdditionalCost;
import hu.charmanthere.ease.dao.entity.Contract;
import hu.charmanthere.ease.dao.entity.Event;
import hu.charmanthere.ease.dao.enumeration.EventCategory;
import hu.charmanthere.ease.dao.implementation.ContractDaoImpl;
import hu.charmanthere.ease.dao.implementation.EventDaoImpl;
import hu.charmanthere.ease.exception.EventWithIdDoesNotExistException;
import hu.charmanthere.ease.service.util.BudgetCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    public EventDaoImpl eventDao;
    public ContractDaoImpl contractDao;

    @Autowired
    public EventService(EventDaoImpl eventDao, ContractDaoImpl contractDao) {
        this.eventDao = eventDao;
        this.contractDao = contractDao;
    }

    public List<Event> findAllEvent() {
        return eventDao.findAll();
    }

    public Event findById(Long id) throws EventWithIdDoesNotExistException {
        return eventDao.findById(id);
    }

    public void createEvent(Event event) {
        eventDao.save(event);
    }

    public void update(Long id, Event event) throws EventWithIdDoesNotExistException {
        eventDao.update(id,event);
    }

    public void deleteById(Long id) {
        eventDao.deleteById(id);
    }

    public List<Event> findEventsByEventCategory(EventCategory eventCategory){
        return eventDao.findEventsByEventCategory(eventCategory);
    }
    public List<Event> findEventsByLocality(String locality){
        return eventDao.findEventsByLocality(locality);
    }
    public List<Event> findEventsByDate(LocalDate localDate){
        return eventDao.findEventsByDateTime(localDate.atStartOfDay());
    }

    public Double getEventBudgetByEventId(Long id) throws EventWithIdDoesNotExistException {
        Event searchedEvent = eventDao.findById(id);
        List<Contract> contracts = contractDao.findAllByEvent(searchedEvent);
        Integer sumContractPrices = 0;
        if(!contracts.isEmpty()){
            sumContractPrices = contracts.stream().map(c -> c.getPrice()).mapToInt(Integer::intValue).sum();
        }
        List<AdditionalCost> additionalCosts = searchedEvent.getAdditionalCostList();
        Double sumAdditionalCosts = 0.0;
        if(!additionalCosts.isEmpty()){
            sumAdditionalCosts = additionalCosts.stream().map(a-> a.getPrice()).mapToDouble(Double::doubleValue).sum();
        }
        return sumContractPrices + sumAdditionalCosts;
    }

    public Double getRemainingAmountFromEventBudgetByEventId(Long id) throws EventWithIdDoesNotExistException {
        Event searchedEvent = eventDao.findById(id);
        List<Contract> contracts = contractDao.findAllByEvent(searchedEvent);
        return BudgetCalculator.getRemainingAmountFromEventBudget(contracts);
    }

    public Double getPaidAmountFromEventBudgetByEventId(Long id) throws EventWithIdDoesNotExistException {
        Event searchedEvent = eventDao.findById(id);
        List<Contract> contracts = contractDao.findAllByEvent(searchedEvent);
        List<AdditionalCost> additionalCosts = searchedEvent.getAdditionalCostList();
        return BudgetCalculator.getPaidAmountFromEventBudget(contracts, additionalCosts);
    }
}
