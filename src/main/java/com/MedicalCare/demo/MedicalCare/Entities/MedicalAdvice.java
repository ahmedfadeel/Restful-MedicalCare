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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Mustafa
 */
@Entity
@Table(name = "medicalAdvice")
public class MedicalAdvice implements Serializable {
	
	private static final long serialVersionUID = 902258783495L;


    private long id;
    @NotNull(message = "tybe is requried")
    private String tybe;
    @NotNull(message = "the content is requried")
    private String txt;
    private diognes diognes;
    private Disease disease;
    
    public MedicalAdvice() {
		// TODO Auto-generated constructor stub
	}

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diseas_id")
    @JsonIgnore
    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diognes_id")
    @JsonIgnore
    public diognes getDiognes() {
        return diognes;
    }

    public void setDiognes(diognes diognes) {
        this.diognes = diognes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "advice_pk", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "advice_tybe", nullable = false)
    public String getTybe() {
        return tybe;
    }

    public void setTybe(String tybe) {
        this.tybe = tybe;
    }

    @Column(name = "advice_txt", nullable = false)
    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

	@Override
	public String toString() {
		return "MedicalAdvice [id=" + id + ", tybe=" + tybe + ", txt=" + txt + ", diognes=" + diognes + ", disease="
				+ disease + "]";
	}

    
}

