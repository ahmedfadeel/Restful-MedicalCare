package com.MedicalCare.demo.MedicalCare.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Mustafa
 */
@Entity
@Table(name = "disease")
public class Disease implements Serializable {
	private static final long serialVersionUID = 90278374195L;


    private int id;
    @NotNull(message="name is requried")
    @Size(min=2,message="name is requried")
    private String name;
    private String info;
    @NotNull(message="tybe is requried")
    private String tybe;
    private List<MedicalAdvice> medicalAdviceList;
    private List<Patient> patientsList;
    private List<diognes> dioList;
    
    public Disease() {
		// TODO Auto-generated constructor stub
	}

    @OneToMany(cascade = CascadeType.ALL,targetEntity = diognes.class,mappedBy = "disease")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<diognes> getDioList() {
        return dioList;
    }

    public void setDioList(List<diognes> dioList) {
        this.dioList = dioList;
    }
    

    @ManyToMany(cascade = CascadeType.ALL,targetEntity = Patient.class)
    @JoinTable(name="dis_pat",joinColumns = {
    @JoinColumn(name = "dis_id")},inverseJoinColumns = {
    @JoinColumn(name = "pat_id")})
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Patient> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(List<Patient> patientsList) {
        this.patientsList = patientsList;
    }
    

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "disease",targetEntity = MedicalAdvice.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<MedicalAdvice> getMedicalAdviceList() {
        return medicalAdviceList;
    }

    public void setMedicalAdviceList(List<MedicalAdvice> medicalAdviceList) {
        this.medicalAdviceList = medicalAdviceList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "desease_pk", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "desease_name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "desease_info", nullable = true)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Column(name = "desese_tybe", nullable = false)
    public String getTybe() {
        return tybe;
    }

    public void setTybe(String tybe) {
        this.tybe = tybe;
    }

	@Override
	public String toString() {
		return "Disease [id=" + id + ", name=" + name + ", info=" + info + ", tybe=" + tybe + ", medicalAdviceList="
				+ medicalAdviceList + ", patientsList=" + patientsList + ", dioList=" + dioList + "]";
	}

    
}
