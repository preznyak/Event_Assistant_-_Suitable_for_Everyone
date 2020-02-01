package hu.charmanthere.ease.dao.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "userDetails")
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userDetailsId;

    private LocalDate registrationDate;

    private LocalDate birthDay;

    private String preferences;

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
