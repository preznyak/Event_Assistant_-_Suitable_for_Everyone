package hu.charmanthere.ease.dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "guest")
@Table(name = "guests")
@SequenceGenerator(name = "guest_seq")
public class Guest implements Serializable {

    private static final long serialVersionUID = 123846L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_seq")
    private Long guestId;

    private String firstName;

    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contact contact;

    private Boolean isInvitationAccepted;

    public Guest() {
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Boolean getInvitationAccepted() {
        return isInvitationAccepted;
    }

    public void setInvitationAccepted(Boolean invitationAccepted) {
        isInvitationAccepted = invitationAccepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return guestId.equals(guest.guestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
