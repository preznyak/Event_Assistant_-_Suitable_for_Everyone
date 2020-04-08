package hu.charmanthere.ease.controller.model.user;

import hu.charmanthere.ease.controller.model.userdetails.UserDetailsModel;
import java.time.LocalDate;

public class UserModel {
    private String email;

    private String password;

    private LocalDate lastLoginDate;

    private boolean serviceOwner;

    private UserDetailsModel userDetailsModel;

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

    public UserDetailsModel getUserDetailsModel() {
        return userDetailsModel;
    }

    public void setUserDetailsModel(UserDetailsModel userDetailsModel) {
        this.userDetailsModel = userDetailsModel;
    }
}
