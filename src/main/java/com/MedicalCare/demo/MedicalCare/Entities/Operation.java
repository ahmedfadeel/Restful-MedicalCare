package com.MedicalCare.demo.MedicalCare.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Mustafa
 */
@Entity
@Table(name = "operation")
public class Operation implements Serializable {

	private static final long serialVersionUID = 902780783495L;

    private long id;
    private Date date;
    @NotNull(message="name is requried")
    private String name;
    @NotNull(message="hospital name is requried")
    private String hopitalName;
    private Doctor doctor;
    private Patient patient;
    
    public Operation() {
		// TODO Auto-generated constructor stub
	}

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_id")
    @JsonIgnore
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pat_id")
    @JsonIgnore
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "operation_pk", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "opration_date", nullable = false, unique = false)
    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "operation_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "operation_hospital_name", nullable = false)
    public String getHopitalName() {
        return hopitalName;
    }

    public void setHopitalName(String hopitalName) {
        this.hopitalName = hopitalName;
    }

	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", name=" + name + ", hopitalName=" + hopitalName
				+ ", doctor=" + doctor + ", patient=" + patient + "]";
	}
    
    

}
