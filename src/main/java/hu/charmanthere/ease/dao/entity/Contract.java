package hu.charmanthere.ease.dao.entity;

import hu.charmanthere.ease.dao.enumeration.PaymentMethod;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "contract")
@Table(name = "contracts")
@SequenceGenerator(name = "contract_seq")
public class Contract implements Serializable {

    private static final long serialVersionUID = 411118L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_seq")
    private Long contractId;

    private Integer price;

    private Integer deposit;

    private String description;

    private LocalDateTime pricePaymentTime;

    private LocalDateTime depositPaymentTime;

    private Boolean isDepositPayed;

    private Boolean isPricePayed;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    //signature, documents,


    public Contract() {
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPricePaymentTime() {
        return pricePaymentTime;
    }

    public void setPricePaymentTime(LocalDateTime pricePaymentTime) {
        this.pricePaymentTime = pricePaymentTime;
    }

    public LocalDateTime getDepositPaymentTime() {
        return depositPaymentTime;
    }

    public void setDepositPaymentTime(LocalDateTime depositPaymentTime) {
        this.depositPaymentTime = depositPaymentTime;
    }

    public Boolean getDepositPayed() {
        return isDepositPayed;
    }

    public void setDepositPayed(Boolean depositPayed) {
        isDepositPayed = depositPayed;
    }

    public Boolean getPricePayed() {
        return isPricePayed;
    }

    public void setPricePayed(Boolean pricePayed) {
        isPricePayed = pricePayed;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return contractId.equals(contract.contractId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                '}';
    }
}
