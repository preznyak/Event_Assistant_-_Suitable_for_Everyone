package hu.charmanthere.ease.dao.entity;

import hu.charmanthere.ease.dao.enumeration.EventCategory;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity(name = "event")
@Table(name = "events")
@SequenceGenerator(name = "event_seq")
public class Event implements Serializable {

    private static final long serialVersionUID = -44216L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @Column(unique = true, nullable = false)
    private Long eventId;

    private String eventName;

    private String locality;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EventDetails eventDetails;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdditionalCost> additionalCostList;

    private LocalDateTime created;

    @Enumerated(EnumType.STRING)
    private EventCategory eventCategory;

    public Event() {
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public List<AdditionalCost> getAdditionalCostList() {
        return additionalCostList;
    }

    public void setAdditionalCostList(List<AdditionalCost> additionalCostList) {
        this.additionalCostList = additionalCostList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventId.equals(event.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", eventCategory=" + eventCategory +
                '}';
    }
}
