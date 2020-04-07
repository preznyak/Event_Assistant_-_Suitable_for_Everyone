package hu.charmanthere.ease.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity(name = "eventDetails")
@Table(name = "event_details")
@SequenceGenerator(name = "event_details_seq")
public class EventDetails implements Serializable {

    private static final long serialVersionUID = 9134846L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_details_seq")
    private Long eventDetailsId;

    private String description;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Guest> guestList;

    public EventDetails() {
    }

    public Long getEventDetailsId() {
        return eventDetailsId;
    }

    public void setEventDetailsId(Long eventDetailsId) {
        this.eventDetailsId = eventDetailsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDetails that = (EventDetails) o;
        return eventDetailsId.equals(that.eventDetailsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventDetailsId);
    }

    @Override
    public String toString() {
        return "EventDetails{" + eventDetailsId +
                '}';
    }
}
