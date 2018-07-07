package com.MedicalCare.demo.MedicalCare.Entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 *
 * @author Mustafa
 */
@Entity
@Table(name = "doctors")
@JsonIgnoreProperties(value= {"patients"})
public class Doctor implements Serializable {
	
	private static final long serialVersionUID = 90277783495L;


	@NotNull(message="personal id is requried")
	@Pattern(regexp="(2|3)[0-9][1-9][0-1][1-9][0-3][1-9](01|02|03|04|11|12|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|31|32|33|34|35|88)\\d\\d\\d\\d\\d",message="this is not a valid personal id")
    private long id;
    @NotNull(message="name is requried")
    @Size(min=2,message="name lenght must greater than one character")
    private String name;
    @Past(message="the birthdate must be at past")
    private Date bithDate;
    @NotNull(message="your fauclty is requried")
    @Size(min=2,message="short name to the fauclty")
    private String fauclty;
    @NotNull(message="your department is requried")
    private String department;
    @NotNull(message="your email is requried")
    @Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$",message="email must be as test@test.test")
    private String email;
    @NotNull(message="your phone is requried")
    @Pattern(regexp="(201)[0-9]{9}" ,message = "this is not a sutable phone number")
    private String phone;
    
    private MultipartFile image;
    
    private Address homeAddress;
   // private Address clinicAddress;
    private String otherInfo;

    private List<Patient> patients;
    private Hospital doctorHospital;
    private List<diognes> dioList;
    private List<Operation> operations;
    private List<Analysis> analysises;
    
    private String imagePath;
    
    public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Doctor() {
		// TODO Auto-generated constructor stub
	}
    
    @OneToMany(cascade = CascadeType.ALL,targetEntity = Analysis.class,mappedBy = "doctor")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    public List<Analysis> getAnalysises() {
        return analysises;
    }

    public void setAnalysises(List<Analysis> analysises) {
        this.analysises = analysises;
    }

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Operation.class,mappedBy = "doctor")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @OneToMany(cascade = CascadeType.ALL,targetEntity = diognes.class,mappedBy = "doctor")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<diognes> getDioList() {
        return dioList;
    }

    public void setDioList(List<diognes> dioList) {
        this.dioList = dioList;
    }

    @ManyToMany(cascade = CascadeType.ALL,targetEntity = Patient.class)
    @JoinTable(name="doc_pat",joinColumns = {
    @JoinColumn(name = "doc_id")},inverseJoinColumns = {
    @JoinColumn(name = "pat_id")})
    @LazyCollection(LazyCollectionOption.FALSE)
    
    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hos_id")
    @JsonIgnore
    public Hospital getDoctorHospital() {
        return doctorHospital;
    }

    public void setDoctorHospital(Hospital doctorHospital) {
        this.doctorHospital = doctorHospital;
    }

    @Id
    @Column(name = "doctor_pk", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "doctor_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "doctor_birthdate", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getBithDate() {
        return bithDate;
    }

    public void setBithDate(Date bithDate) {
        this.bithDate = bithDate;
    }

    @Column(name = "doctor_fauclty", nullable = false)
    public String getFauclty() {
        return fauclty;
    }

    public void setFauclty(String fauclty) {
        this.fauclty = fauclty;
    }

    @Column(name = "doctor_department", nullable = false)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Column(name = "doctor_email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "doctor_phone", nullable = false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Transient
    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @Embedded
    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

//    @Embedded
//    @AttributeOverrides({
//        @AttributeOverride(name = "home_city", column = @Column(name = "clinic_city"))
//        ,@AttributeOverride(name = "home_street", column = @Column(name = "clinic_street"))
//        ,@AttributeOverride(name = "home_government", column = @Column(name = "clinic_government"))
//    })
//    public Address getClinicAddress() {
//        return clinicAddress;
//    }

//    public void setClinicAddress(Address clinicAddress) {
//        this.clinicAddress = clinicAddress;
//    }

    @Column(name = "info", nullable = true)
    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
    private String clinikCity;
    private String clinicStreet;
    private String clinicGoverment;


	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", bithDate=" + bithDate + ", fauclty=" + fauclty
				+ ", department=" + department + ", email=" + email + ", phone=" + phone + ", image=" + image
				+ ", homeAddress=" + homeAddress + ", otherInfo=" + otherInfo + ", patients=" + patients
				+ ", doctorHospital=" + doctorHospital + ", dioList=" + dioList + ", operations=" + operations
				+ ", analysises=" + analysises + ", imagePath=" + imagePath + ", clinikCity=" + clinikCity
				+ ", clinicStreet=" + clinicStreet + ", clinicGoverment=" + clinicGoverment + "]";
	}

	@Column(name = "clink_city")
	public String getClinikCity() {
		return clinikCity;
	}

	public void setClinikCity(String clinikCity) {
		this.clinikCity = clinikCity;
	}

	@Column(name = "clink_street")
	public String getClinicStreet() {
		return clinicStreet;
	}

	public void setClinicStreet(String clinicStreet) {
		this.clinicStreet = clinicStreet;
	}

	@Column(name = "clink_government")
	public String getClinicGoverment() {
		return clinicGoverment;
	}

	public void setClinicGoverment(String clinicGoverment) {
		this.clinicGoverment = clinicGoverment;
	}

    
}
