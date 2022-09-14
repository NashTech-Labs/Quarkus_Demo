package com.contact;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "contacts")
@Entity
public class Contact implements Serializable {

    private Long contactId;
    private String firstName;
    private String lastName;
    private String companyName;

    public Contact() {
    }

    public Contact(Long contactId, String firstName, String lastName, String companyName) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}