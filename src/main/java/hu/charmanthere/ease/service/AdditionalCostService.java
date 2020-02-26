package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.AdditionalCost;
import hu.charmanthere.ease.dao.implementation.AdditionalCostDaoImpl;
import hu.charmanthere.ease.exception.AdditionalCostWithIdDoesNotExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalCostService {

    private static final Logger LOGGER = LogManager.getLogger(AdditionalCostService.class);

    private AdditionalCostDaoImpl additionalCostDao;

    @Autowired
    public AdditionalCostService(AdditionalCostDaoImpl additionalCostDao) {
        this.additionalCostDao = additionalCostDao;
    }

    public void deleteById(Long additionalCostId) {
        additionalCostDao.deleteById(additionalCostId);
    }

    public void save(AdditionalCost additionalCost) {
        additionalCostDao.save(additionalCost);
        LOGGER.info("Log4j is working. Additional Cost created.");
    }

    public List<AdditionalCost> findAll() {
        return additionalCostDao.findAll();
    }

    public AdditionalCost findById(Long id) throws AdditionalCostWithIdDoesNotExistException {
        return additionalCostDao.findById(id);
    }

    public void update(Long id, AdditionalCost additionalCost) throws AdditionalCostWithIdDoesNotExistException {
        additionalCostDao.save(additionalCost);
    }
}
