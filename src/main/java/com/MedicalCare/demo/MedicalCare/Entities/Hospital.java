package com.MedicalCare.demo.MedicalCare.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Mustafa
 */
@Entity
@Table(name = "hospitals")
@JsonIgnoreProperties(value= {"hospitalPatients","doctors"})
public class Hospital implements Serializable {

	private static final long serialVersionUID = 9102783495L;

    private int id;
    @NotNull(message="name is requried")
    private String name;
    @NotNull(message="phone is requried")
    @Pattern(regexp="(201)[0-9]{9}" ,message = "this is not a sutable phone number")
    private String phone;
    private Address address;
    List<Doctor> doctors;
    List<Patient> hospitalPatients;
    
    public Hospital() {
		// TODO Auto-generated constructor stub
	}

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "doctorHospital",targetEntity = Doctor.class)
    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @ManyToMany(cascade = CascadeType.ALL,targetEntity = Patient.class)
    @JoinTable(name="hos_pat",joinColumns = {
    @JoinColumn(name = "hos_id")},inverseJoinColumns = {
    @JoinColumn(name = "pat_id")})
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Patient> getHospitalPatients() {
        return hospitalPatients;
    }

    public void setHospitalPatients(List<Patient> hospitalPatients) {
        this.hospitalPatients = hospitalPatients;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hospital_pk", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "hospital_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "hospital_phone", nullable = false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", doctors="
				+ doctors + ", hospitalPatients=" + hospitalPatients + "]";
	}
    
    

}
