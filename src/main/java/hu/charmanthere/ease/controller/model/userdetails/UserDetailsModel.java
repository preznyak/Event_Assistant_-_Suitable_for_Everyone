package hu.charmanthere.ease.controller.model.userdetails;

import hu.charmanthere.ease.controller.model.address.AddressModel;
import hu.charmanthere.ease.controller.model.contact.ContactModel;
import java.time.LocalDate;
import java.util.List;

public class UserDetailsModel {
    private String firstName;

    private String lastName;

    private LocalDate registrationDate;

    private LocalDate birthDay;

    private String preferences;

    private List<AddressModel> addressModelList;

    private ContactModel contactModel;

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

    public List<AddressModel> getAddressModelList() {
        return addressModelList;
    }

    public void setAddressModelList(List<AddressModel> addressModelList) {
        this.addressModelList = addressModelList;
    }

    public ContactModel getContactModel() {
        return contactModel;
    }

    public void setContactModel(ContactModel contactModel) {
        this.contactModel = contactModel;
    }
}
