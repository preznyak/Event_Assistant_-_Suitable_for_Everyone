package hu.charmanthere.ease.dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name = "userDetails")
@Table(name = "user_details")
@SequenceGenerator(name = "user_details_seq")
public class UserDetails implements Serializable {

    private static final long serialVersionUID = -4512356L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_details_seq")
    private Long userDetailsId;

    private String firstName;

    private String lastName;

    private LocalDate registrationDate;

    private LocalDate birthDay;

    private String preferences;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addressList;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Contact contact;

    public UserDetails() {
    }

    public Long getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(Long userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
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

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails that = (UserDetails) o;
        return userDetailsId.equals(that.userDetailsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userDetailsId);
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userDetailsId=" + userDetailsId +
                '}';
    }
}
