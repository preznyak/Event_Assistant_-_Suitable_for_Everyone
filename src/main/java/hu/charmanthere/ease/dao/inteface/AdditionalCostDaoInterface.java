package hu.charmanthere.ease.dao.inteface;

import hu.charmanthere.ease.dao.entity.AdditionalCost;
import hu.charmanthere.ease.exception.AdditionalCostWithIdDoesNotExistException;

import java.util.List;

public interface AdditionalCostDaoInterface {

    void deleteById(Long additionalCostId);

    void save(AdditionalCost additionalCost);

    List<AdditionalCost> findAll();

    AdditionalCost findById(Long id) throws AdditionalCostWithIdDoesNotExistException;

    void update(Long id, AdditionalCost additionalCost) throws AdditionalCostWithIdDoesNotExistException;
}
