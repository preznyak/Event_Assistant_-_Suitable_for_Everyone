package hu.charmanthere.ease.dao.implementation;

import hu.charmanthere.ease.dao.entity.AdditionalCost;
import hu.charmanthere.ease.dao.inteface.AdditionalCostDaoInterface;
import hu.charmanthere.ease.dao.repository.AdditionalCostRepositoryInterface;
import hu.charmanthere.ease.exception.AdditionalCostWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalCostDaoImpl implements AdditionalCostDaoInterface {

    private AdditionalCostRepositoryInterface additionalCostRepositoryInterface;

    @Autowired
    public AdditionalCostDaoImpl(AdditionalCostRepositoryInterface additionalCostRepositoryInterface) {
        this.additionalCostRepositoryInterface = additionalCostRepositoryInterface;
    }

    @Override
    public void deleteById(Long additionalCostId) {
        additionalCostRepositoryInterface.deleteById(additionalCostId);
    }

    @Override
    public void save(AdditionalCost additionalCost) {
        additionalCostRepositoryInterface.save(additionalCost);
    }

    @Override
    public List<AdditionalCost> findAll() {
        return additionalCostRepositoryInterface.findAll();
    }

    @Override
    public AdditionalCost findById(Long id) throws AdditionalCostWithIdDoesNotExistException {
        AdditionalCost additionalCost = additionalCostRepositoryInterface.findById(id).orElse(null);
        if(additionalCost == null){
            System.out.println("Additional Cost with " + id + " does not exist!");
            throw new AdditionalCostWithIdDoesNotExistException("Additional Cost with " + id + " does not exist!");
        }
        return additionalCost;
    }

    @Override
    public void update(Long id, AdditionalCost additionalCost) throws AdditionalCostWithIdDoesNotExistException {
        AdditionalCost additionalCostToBeUpdated = additionalCostRepositoryInterface.findById(id).orElse(null);
        if(additionalCostToBeUpdated == null){
            //TODO logger
            System.out.println("Additional Cost with " + id + " does not exist!");
            throw new AdditionalCostWithIdDoesNotExistException("Additional Cost with " + id + " does not exist!");
        }
        additionalCostToBeUpdated.setDate(additionalCost.getDate());
        additionalCostToBeUpdated.setDescription(additionalCost.getDescription());
        additionalCostToBeUpdated.setName(additionalCost.getName());
        additionalCostToBeUpdated.setPrice(additionalCost.getPrice());
        additionalCostRepositoryInterface.save(additionalCostToBeUpdated);
    }
}
