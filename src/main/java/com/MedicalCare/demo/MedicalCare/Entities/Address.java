package com.MedicalCare.demo.MedicalCare.Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Mustafa
 */
@Embeddable
public class Address {
    private String city;
    private String street;
    private String goverment;

    @Column(name = "home_city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "home_street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "home_government")
    public String getGoverment() {
        return goverment;
    }

    public void setGoverment(String goverment) {
        this.goverment = goverment;
    }
    
}
