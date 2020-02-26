package hu.charmanthere.ease.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "additional_cost")
@Table(name = "additional_costs")
@SequenceGenerator(name = "additional_cost_seq")
public class AdditionalCost implements Serializable {

    private static final long serialVersionUID = -10000246L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "additional_cost_seq")
    private Long additionalCostId;

    private Double price;

    private String name;

    private String description;

    private LocalDate date;

    public AdditionalCost() {
    }

    public Long getAdditionalCostId() {
        return additionalCostId;
    }

    public void setAdditionalCostId(Long additionalCostId) {
        this.additionalCostId = additionalCostId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AdditionalCost{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
