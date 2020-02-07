package hu.charmanthere.ease.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "contact")
@Table(name = "contacts")
@SequenceGenerator(name = "contact_seq")
public class Contact implements Serializable {

    private static final long serialVersionUID = -6546132L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq")
    @Column(unique = true, nullable = false)
    private Long contactId;

    private String name;

    private String phoneNumber;

    private String email;

    private String facebookLink;

    public Contact() {
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }
}
