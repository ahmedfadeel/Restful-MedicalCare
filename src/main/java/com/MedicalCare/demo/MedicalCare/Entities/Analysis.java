package com.MedicalCare.demo.MedicalCare.Entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Mustafa
 */
@Entity
@Table(name = "analysis")
public class Analysis implements Serializable {
	private static final long serialVersionUID = 902783495215L;


    private long id;
    private String path;
    @NotNull(message="name is requried")
    private String name;
    private MultipartFile image;
    private Date date;
    private Doctor doctor;
    private Patient patient;
    
    public Analysis() {
		// TODO Auto-generated constructor stub
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "analysis_pk", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "analyst_path")
    public String getBath() {
        return path;
    }

    public void setBath(String bath) {
        this.path = bath;
    }

    @Column(name = "analysis_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @Column(name = "Analysis_date",nullable = false,unique = false)
    @Temporal(TemporalType.DATE)
    public Date getDate() {	
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="doc_id")
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Analysis [id=" + id + ", path=" + path + ", name=" + name + ", image=" + image + ", date=" + date
				+ ", doctor=" + doctor + ", patient=" + patient + "]";
	}

	

    
}

