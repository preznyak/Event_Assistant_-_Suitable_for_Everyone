package hu.charmanthere.ease.dao.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name = "user")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private LocalDate birthDate;

    private LocalDate lastLoginDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addressList;

    @OneToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    private UserDetails userDetails;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Contact contact;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
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
        User user = (User) o;
        return userId.equals(user.userId) &&
                email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
