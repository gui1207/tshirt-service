package com.acme.entity;

 

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

 
@Entity
@Table(name="customer")
public class CustomerEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @Size(min = 1, max = 40, message = "Address must be between 1 and 40 characters")
    private String address;
    @Size(min = 1, max = 20, message = "neighborhood must be between 1 and 20 characters")
    private String neighborhood;
    @Size(min = 1, max = 20, message = "city must be between 1 and 20 characters")
    private String city;
    @Size(min = 1, max = 20, message = "state or province must be between 1 and 20 characters")
    private String stateOrProvince;
    @Size(min = 1, max = 10, message = "postalCode must be between 1 and 10 characters")
    private String postalCode;
    @Size(min = 1, max = 20, message = "country must be between 1 and 20 characters")
    private String country;
    @Size(min = 1, max = 20, message = "Company must be between 1 and 20 characters")
    private String company;
    @Size(min = 1, max = 20, message = "title must be between 1 and 20 characters")
    private String title;
    @Size(min = 1, max = 15, message = "phone must be between 1 and 15 characters")
    private String phone;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getNeighborhood() {
        return neighborhood;
    }
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStateOrProvince() {
        return stateOrProvince;
    }
    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
}