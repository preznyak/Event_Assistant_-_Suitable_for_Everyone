package hu.charmanthere.ease.dao.entity;

import javax.persistence.*;

@Entity(name = "serviceDetails")
@Table(name = "service_details")
@SequenceGenerator(name = "service_details_seq")
public class ServiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_details_seq")
    private Long id;

    public ServiceDetails() {
    }
}
