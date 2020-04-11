package hu.charmanthere.ease.dao.inteface;

import hu.charmanthere.ease.dao.entity.Contract;
import hu.charmanthere.ease.dao.entity.Event;
import hu.charmanthere.ease.dao.entity.Service;

import java.util.List;

public interface ContractDaoInterface {
    List<Contract> findAllByEvent(Event event);
    List<Contract> findAllByService(Service service);
}
