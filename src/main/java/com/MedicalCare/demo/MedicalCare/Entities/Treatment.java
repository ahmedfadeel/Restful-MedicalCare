package com.MedicalCare.demo.MedicalCare.Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Mustafa
 */
@Entity
@Table(name = "treaments")
public class Treatment implements Serializable {
	
	private static final long serialVersionUID = 932502783495L;


    private long id;
    @NotNull(message="name is requried")
    private String name;
    @NotNull(message="dose is requried")
    private String dose;
    private diognes diognes;
    
    public Treatment() {
		// TODO Auto-generated constructor stub
	}

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dio_id")
    @JsonIgnore
    public diognes getDiognes() {
        return diognes;
    }

    public void setDiognes(diognes diognes) {
        this.diognes = diognes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "treatments_pk", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "treatment_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "treatment_dose", nullable = false)
    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

	@Override
	public String toString() {
		return "Treatment [id=" + id + ", name=" + name + ", dose=" + dose + ", diognes=" + diognes + "]";
	}
    
    

}
