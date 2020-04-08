package hu.charmanthere.ease.controller.model.user;

import hu.charmanthere.ease.controller.model.userdetails.UserDetailsModel;

public class RegisterUserModel {
    private String email;

    private String password;

    private String confirmPassword;

    private UserDetailsModel userDetailsModel;

    public RegisterUserModel() {
    }

    public RegisterUserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    public UserDetailsModel getUserDetailsModel() {
        return userDetailsModel;
    }

    public void setUserDetailsModel(UserDetailsModel userDetailsModel) {
        this.userDetailsModel = userDetailsModel;
    }
}
