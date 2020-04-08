package hu.charmanthere.ease.controller.model.user;

import java.time.LocalDate;

public class UserListModel {
    private String email;

    private String password;

    private LocalDate lastLoginDate;

    private boolean serviceOwner;

    private String userFirstName;

    private String userLastName;

    private LocalDate userRegistrationDate;

    private LocalDate userBirthDay;

    private String userPreferences;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public boolean isServiceOwner() {
        return serviceOwner;
    }

    public void setServiceOwner(boolean serviceOwner) {
        this.serviceOwner = serviceOwner;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public LocalDate getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(LocalDate userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    public LocalDate getUserBirthDay() {
        return userBirthDay;
    }

    public void setUserBirthDay(LocalDate userBirthDay) {
        this.userBirthDay = userBirthDay;
    }

    public String getUserPreferences() {
        return userPreferences;
    }

    public void setUserPreferences(String userPreferences) {
        this.userPreferences = userPreferences;
    }

}
