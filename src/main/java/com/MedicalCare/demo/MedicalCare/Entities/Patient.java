package com.MedicalCare.demo.MedicalCare.Entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Mustafa
 */
@Entity
@Table(name = "patients")
@JsonIgnoreProperties(value= {"patientHospitals","doctors","diseasesList"})
public class Patient implements Serializable {
	
	private static final long serialVersionUID = 90278349955L;


	@NotNull(message="personal id is requried")
	@Pattern(regexp="(2|3)[0-9][1-9][0-1][1-9][0-3][1-9](01|02|03|04|11|12|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|31|32|33|34|35|88)\\d\\d\\d\\d\\d",message="this is not a valid personal id")    
    private long id;
	@NotNull(message="name is requried")
    @Size(min=2,message="name lenght must greater than one character")
    private String name;
	@Past(message="the birthdate must be at past")
    private Date birthDate;
	@NotNull(message="the gender is requried")
    private String gender;
	@NotNull(message="your phone is requried")
	@Pattern(regexp="(201)[0-9]{9}" ,message = "this is not a sutable phone number")
    private String phone;
	@NotNull(message="your email is requried")
    @Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$",message="email must be as test@test.test")   
    private String email;
    private MultipartFile image;
    private Address address;
    @Pattern(regexp="[0-9]{2,3}")
    private String lenth;
    @Pattern(regexp="[0-9]{1,3}")
    private String weight;
    private List<Hospital> patientHospitals;

    private List<Doctor> doctors;
    private List<diognes> dioList;
    private List<Operation> operations;
    private List<Disease> diseasesList;
    private List<Analysis> analysises;
    
    private String ImagePath;
    public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}

	public Patient() {
		// TODO Auto-generated constructor stub
	}

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Analysis.class, mappedBy = "patient")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Analysis> getAnalysises() {
        return analysises;
    }

    public void setAnalysises(List<Analysis> analysises) {
        this.analysises = analysises;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "dis_pat", joinColumns = {
        @JoinColumn(name = "pat_id")}, inverseJoinColumns = {
        @JoinColumn(name = "dis_id")})
    public List<Disease> getDiseasesList() {
        return diseasesList;
    }

    public void setDiseasesList(List<Disease> diseasesList) {
        this.diseasesList = diseasesList;
    }

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Operation.class, mappedBy = "patient")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "doc_pat", joinColumns = {
        @JoinColumn(name = "pat_id")}, inverseJoinColumns = {
        @JoinColumn(name = "doc_id")})
    public List<Doctor> getDoctors() {
        return doctors;
    }

    @OneToMany(cascade = CascadeType.ALL, targetEntity = diognes.class,  mappedBy = "patient")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<diognes> getDioList() {
        return dioList;
    }

    public void setDioList(List<diognes> dioList) {
        this.dioList = dioList;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hos_pat", joinColumns = {
        @JoinColumn(name = "pat_id")}, inverseJoinColumns = {
        @JoinColumn(name = "hos_id")})
    public List<Hospital> getPatientHospitals() {
        return patientHospitals;
    }

    public void setPatientHospitals(List<Hospital> patientHospitals) {
        this.patientHospitals = patientHospitals;
    }

    @Id
    @Column(name = "patient_pk", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "patient_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "patient_birthDate", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "patient_gender", nullable = false)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "patient_phone", nullable = true)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "patient_email", nullable = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Transient
    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "patient_lenth", nullable = true)
    public String getLenth() {
        return lenth;
    }

    public void setLenth(String lenth) {
        this.lenth = lenth;
    }

    @Column(name = "patient_weight", nullable = true)
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", phone="
				+ phone + ", email=" + email + ", image=" + image + ", address=" + address + ", lenth=" + lenth
				+ ", weight=" + weight + ", patientHospitals=" + patientHospitals + ", doctors=" + doctors
				+ ", dioList=" + dioList + ", operations=" + operations + ", diseasesList=" + diseasesList
				+ ", analysises=" + analysises + ", ImagePath=" + ImagePath + "]";
	}

	

	
    
    

}
