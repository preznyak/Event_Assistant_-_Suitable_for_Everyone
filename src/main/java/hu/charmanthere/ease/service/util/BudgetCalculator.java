package hu.charmanthere.ease.service.util;

import hu.charmanthere.ease.dao.entity.AdditionalCost;
import hu.charmanthere.ease.dao.entity.Contract;
import hu.charmanthere.ease.dao.entity.Event;

import java.util.List;

public class BudgetCalculator {

    public static Double getPaidAmountFromEventBudget(List<Contract> contractList, List<AdditionalCost> additionalCostList){
        Double paidAmount = 0.0;
        if(!contractList.isEmpty()){
            for(Contract contract : contractList){
                if(contract.getDepositPayed()){
                    paidAmount += contract.getDeposit();
                }
                if(contract.getPricePayed()){
                    paidAmount += contract.getPrice();
                }
            }
        }
        if(!additionalCostList.isEmpty()) {
            paidAmount += additionalCostList.stream().map(a -> a.getPrice()).mapToDouble(Double::doubleValue).sum();
        }
        return paidAmount;
    }

    public static Double getRemainingAmountFromEventBudget(List<Contract> contractList){
        Double remainingAmount = 0.0;
        if(!contractList.isEmpty()){
            for(Contract contract : contractList){
                if(contract.getDepositPayed() && !contract.getPricePayed()){
                    remainingAmount += contract.getPrice() - contract.getDeposit();
                } else if(!contract.getDepositPayed() && !contract.getPricePayed()){
                    remainingAmount += contract.getPrice();
                }
            }
        }
        return remainingAmount;
    }
}
