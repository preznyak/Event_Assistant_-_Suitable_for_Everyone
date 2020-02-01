package hu.charmanthere.ease.dao.entities;

import hu.charmanthere.ease.dao.enums.PaymentMethod;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "contract")
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long contractId;

    @OneToOne(fetch = FetchType.EAGER)
    private Service service;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    private Event event;

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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", service=" + service +
                ", user=" + user +
                '}';
    }
}
