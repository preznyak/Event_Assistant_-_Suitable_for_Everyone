package hu.charmanthere.ease.dao.entities;

import hu.charmanthere.ease.dao.enums.PaymentMethod;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "offer")
@Table(name = "offers")
@SequenceGenerator(name = "offer_seq")
public class Offer implements Serializable {

    private static final long serialVersionUID = 1964846L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_seq")
    private Long offerId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Event event;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Service service;

    private String description;

    private Integer price;

    private Integer deposit;

    private LocalDateTime pricePaymentTime;

    private LocalDateTime depositPaymentTime;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Boolean isOfferAccepted;

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Boolean getOfferAccepted() {
        return isOfferAccepted;
    }

    public void setOfferAccepted(Boolean offerAccepted) {
        isOfferAccepted = offerAccepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return offerId.equals(offer.offerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "event=" + event +
                ", service=" + service +
                '}';
    }
}
