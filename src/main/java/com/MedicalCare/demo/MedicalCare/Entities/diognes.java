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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 *
 * @author Mustafa
 */
@Entity
@Table(name = "diognes")
public class diognes implements Serializable {
	
	private static final long serialVersionUID = 90278378495L;


    private long id;
    private Date date;
    private String preature;
    private String pulse;
    private String temperature;
    private String BMI;
    private String gemeralApperance;
    private String facialExpression;
    private String painAssessment;
    private boolean pallor;
    private boolean cyanosis;
    private boolean jaundice;
    private boolean hairDistibution;
    private boolean unexpectedBruise;
    private boolean Scars;
    private boolean veins;
    private boolean stiffness;
    private boolean thyroid;
    private boolean lNodes;
    private String headNeckOthers;
    private String headSutures;
    private String headFontanels;
    private boolean expansion;
    private boolean breathingSounds;
    private boolean advSounds;
    private String breast;
    private String chestComments;
    private String heartSounds;
    private String murmurs;
    private String heartOthers;
    private String liver;
    private String spleen;
    private String kidneys;
    private boolean ascites;
    private String ascitesNote;
    private boolean masses;
    private String abdomenOthers;
    private String extGenetalia;
    private boolean upperLimdstremors;
    private boolean upperLimdsclubbing;
    private String upperLimdsjoints;
    private String upperLimdsOthers;
    private boolean lowerLimbsOdema;
    private boolean lowerLimdsclubbing;
    private String lowerLimdsjoints;
    private String lowerLimdsOthers;
    private boolean disabilitesMotor;
    private boolean hearing;
    private boolean visual;
    private boolean mental;
    private boolean psychic;
    private boolean autism;
    private boolean learningDisabilities;
    private String possibleCause;
    private String Deformities;
    private String neurologicalMotor;
    private String neurologicalSensory;
    private String neurologicalOthers;
    private String eyesAcuityTR;
    private String eyesAcuityTL;
    private String eyesAcuityBR;
    private String eyesAcuityBL;
    private String eyesMovementR;
    private String eyesMovementL;
    private String eyesCorneaR;
    private String eyesCorneaL;
    private String eyesPupilR;
    private String eyesPupilL;
    private String eyesComment;
    private String hearingR;
    private String hearingL;
    private boolean nose;
    private String earDischargeR;
    private String earDischargeL;
    private boolean throat;
    private String comments;
    private boolean nutritionalRiskAssessment;
    private String nutritionalRiskAssessmentComment;
    private String functionalRehabilitationAssessment;
    private String fallRiskAssessment;
    private boolean riskForDM;
    private boolean riskForHypertension;
    private boolean riskForOthers;
    private boolean riskForComments;
    private String conclusion;
    private Doctor doctor;
    private Patient patient;
    private List<Treatment> treaments;
    private List<MedicalAdvice> medicalAdvicesList;
    private Disease disease;
    
    public diognes() {
		// TODO Auto-generated constructor stub
	}

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "disease_id")
    @JsonIgnore
    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
    

    @OneToMany(cascade = CascadeType.ALL,targetEntity = MedicalAdvice.class,mappedBy = "diognes")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<MedicalAdvice> getMedicalAdvicesList() {
        return medicalAdvicesList;
    }

    public void setMedicalAdvicesList(List<MedicalAdvice> medicalAdvicesList) {
        this.medicalAdvicesList = medicalAdvicesList;
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

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Treatment.class,mappedBy = "diognes")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Treatment> getTreaments() {
        return treaments;
    }

    public void setTreaments(List<Treatment> treaments) {
        this.treaments = treaments;
    }
    
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "diognes_pk",nullable = false,unique = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "diognes_date",nullable = false,unique = false)
    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

        @Column(name = "diognes_preature",nullable = true)

    public String getPreature() {
        return preature;
    }

    public void setPreature(String preature) {
        this.preature = preature;
    }

            @Column(name = "diognes_pulse",nullable = true)

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

            @Column(name = "diognes_Temperature",nullable = true)

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

            @Column(name = "diognes_bmi",nullable = true)

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }

            @Column(name = "diognes_genAperance",nullable = true)

    public String getGemeralApperance() {
        return gemeralApperance;
    }

    public void setGemeralApperance(String gemeralApperance) {
        this.gemeralApperance = gemeralApperance;
    }

            @Column(name = "diognes_facialExpression",nullable = true)

    public String getFacialExpression() {
        return facialExpression;
    }

    public void setFacialExpression(String facialExpression) {
        this.facialExpression = facialExpression;
    }

            @Column(name = "diognes_painAssess",nullable = true)

    public String getPainAssessment() {
        return painAssessment;
    }

    public void setPainAssessment(String painAssessment) {
        this.painAssessment = painAssessment;
    }

            @Column(name = "diognes_pallor",nullable = false)

    public boolean isPallor() {
        return pallor;
    }

    public void setPallor(boolean pallor) {
        this.pallor = pallor;
    }

    @Column(name = "diognes_cyanosis",nullable = false)
    public boolean isCyanosis() {
        return cyanosis;
    }

    public void setCyanosis(boolean cyanosis) {
        this.cyanosis = cyanosis;
    }

    @Column(name = "diognes_jaundice",nullable = false)
    public boolean isJaundice() {
        return jaundice;
    }

    public void setJaundice(boolean jaundice) {
        this.jaundice = jaundice;
    }

    @Column(name = "diognes_hairDistibution",nullable = false)
    public boolean isHairDistibution() {
        return hairDistibution;
    }

    public void setHairDistibution(boolean hairDistibution) {
        this.hairDistibution = hairDistibution;
    }

    @Column(name = "diognes_unExpecBruise",nullable = false)
    public boolean isUnexpectedBruise() {
        return unexpectedBruise;
    }

    public void setUnexpectedBruise(boolean unexpectedBruise) {
        this.unexpectedBruise = unexpectedBruise;
    }

    @Column(name = "diognes_scars",nullable = false)
    public boolean isScars() {
        return Scars;
    }

    public void setScars(boolean Scars) {
        this.Scars = Scars;
    }

    @Column(name = "diognes_Veins",nullable = false)
    public boolean isVeins() {
        return veins;
    }

    public void setVeins(boolean veins) {
        this.veins = veins;
    }

    @Column(name = "diognes_stiffness",nullable = false)
    public boolean isStiffness() {
        return stiffness;
    }

    public void setStiffness(boolean stiffness) {
        this.stiffness = stiffness;
    }

    @Column(name = "diognes_thyroid",nullable = false)
    public boolean isThyroid() {
        return thyroid;
    }

    public void setThyroid(boolean thyroid) {
        this.thyroid = thyroid;
    }

    @Column(name = "diognes_lnodes",nullable = false)
    public boolean islNodes() {
        return lNodes;
    }

    public void setlNodes(boolean lNodes) {
        this.lNodes = lNodes;
    }

    @Column(name = "diognes_headNeckOthers",nullable = false)
    public String getHeadNeckOthers() {
        return headNeckOthers;
    }

    public void setHeadNeckOthers(String headNeckOthers) {
        this.headNeckOthers = headNeckOthers;
    }

    @Column(name = "diognes_headSutures",nullable = false)
    public String getHeadSutures() {
        return headSutures;
    }

    public void setHeadSutures(String headSutures) {
        this.headSutures = headSutures;
    }

    @Column(name = "diognes_headFontanels",nullable = false)
    public String getHeadFontanels() {
        return headFontanels;
    }

    public void setHeadFontanels(String headFontanels) {
        this.headFontanels = headFontanels;
    }

    @Column(name = "diognes_expansion",nullable = false)
    public boolean isExpansion() {
        return expansion;
    }

    public void setExpansion(boolean expansion) {
        this.expansion = expansion;
    }

    @Column(name = "diognes_breathSounds",nullable = false)
    public boolean isBreathingSounds() {
        return breathingSounds;
    }

    public void setBreathingSounds(boolean breathingSounds) {
        this.breathingSounds = breathingSounds;
    }

    @Column(name = "diognes_advSounds",nullable = false)
    public boolean isAdvSounds() {
        return advSounds;
    }

    public void setAdvSounds(boolean advSounds) {
        this.advSounds = advSounds;
    }

    @Column(name = "diognes_breath",nullable = true)
    public String getBreast() {
        return breast;
    }

    public void setBreast(String breast) {
        this.breast = breast;
    }

    @Column(name = "diognes_chestComments",nullable = true)
    public String getChestComments() {
        return chestComments;
    }

    public void setChestComments(String chestComments) {
        this.chestComments = chestComments;
    }

    @Column(name = "diognes_heartSounds",nullable = true)
    public String getHeartSounds() {
        return heartSounds;
    }

    public void setHeartSounds(String heartSounds) {
        this.heartSounds = heartSounds;
    }

    @Column(name = "diognes_murmurs",nullable = true)
    public String getMurmurs() {
        return murmurs;
    }

    public void setMurmurs(String murmurs) {
        this.murmurs = murmurs;
    }

    @Column(name = "diognes_hraetOther",nullable = true)
    public String getHeartOthers() {
        return heartOthers;
    }

    public void setHeartOthers(String heartOthers) {
        this.heartOthers = heartOthers;
    }

    @Column(name = "diognes_liver",nullable = true)
    public String getLiver() {
        return liver;
    }

    public void setLiver(String liver) {
        this.liver = liver;
    }

    @Column(name = "diognes_Spleen",nullable = true)
    public String getSpleen() {
        return spleen;
    }

    public void setSpleen(String spleen) {
        this.spleen = spleen;
    }

    @Column(name = "diognes_kidneys",nullable = true)
    public String getKidneys() {
        return kidneys;
    }

    public void setKidneys(String kidneys) {
        this.kidneys = kidneys;
    }

    @Column(name = "diognes_ascites",nullable = false)
    public boolean isAscites() {
        return ascites;
    }

    public void setAscites(boolean ascites) {
        this.ascites = ascites;
    }

    @Column(name = "diognes_ascitesNote",nullable = true)
    public String getAscitesNote() {
        return ascitesNote;
    }

    public void setAscitesNote(String ascitesNote) {
        this.ascitesNote = ascitesNote;
    }

    @Column(name = "diognes_masses",nullable = false)
    public boolean isMasses() {
        return masses;
    }

    public void setMasses(boolean masses) {
        this.masses = masses;
    }

    @Column(name = "diognes_abdomenOther",nullable = true)
    public String getAbdomenOthers() {
        return abdomenOthers;
    }

    public void setAbdomenOthers(String abdomenOthers) {
        this.abdomenOthers = abdomenOthers;
    }

    @Column(name = "diognes_extGenetalia",nullable = true)
    public String getExtGenetalia() {
        return extGenetalia;
    }

    public void setExtGenetalia(String extGenetalia) {
        this.extGenetalia = extGenetalia;
    }

    @Column(name = "diognes_upperLimdstremors",nullable = false)
    public boolean isUpperLimdstremors() {
        return upperLimdstremors;
    }

    public void setUpperLimdstremors(boolean upperLimdstremors) {
        this.upperLimdstremors = upperLimdstremors;
    }

    @Column(name = "diognes_upperLimdsclubbing",nullable = false)
    public boolean isUpperLimdsclubbing() {
        return upperLimdsclubbing;
    }

    public void setUpperLimdsclubbing(boolean upperLimdsclubbing) {
        this.upperLimdsclubbing = upperLimdsclubbing;
    }

    @Column(name = "diognes_upperLimdsJoints",nullable = true)
    public String getUpperLimdsjoints() {
        return upperLimdsjoints;
    }

    public void setUpperLimdsjoints(String upperLimdsjoints) {
        this.upperLimdsjoints = upperLimdsjoints;
    }

    @Column(name = "diognes_upperLimdsOther",nullable = true)
    public String getUpperLimdsOthers() {
        return upperLimdsOthers;
    }

    public void setUpperLimdsOthers(String upperLimdsOthers) {
        this.upperLimdsOthers = upperLimdsOthers;
    }

    @Column(name = "diognes_lowerLimbsOdema",nullable = false)
    public boolean isLowerLimbsOdema() {
        return lowerLimbsOdema;
    }

    public void setLowerLimbsOdema(boolean lowerLimbsOdema) {
        this.lowerLimbsOdema = lowerLimbsOdema;
    }

    @Column(name = "diognes_lowerLimdsClubbing",nullable = false)
    public boolean isLowerLimdsclubbing() {
        return lowerLimdsclubbing;
    }

    public void setLowerLimdsclubbing(boolean lowerLimdsclubbing) {
        this.lowerLimdsclubbing = lowerLimdsclubbing;
    }

    @Column(name = "diognes_lowerLimdsJoints",nullable = true)
    public String getLowerLimdsjoints() {
        return lowerLimdsjoints;
    }

    public void setLowerLimdsjoints(String lowerLimdsjoints) {
        this.lowerLimdsjoints = lowerLimdsjoints;
    }

    @Column(name = "diognes_lowerLimdsOthers",nullable = true)
    public String getLowerLimdsOthers() {
        return lowerLimdsOthers;
    }

    public void setLowerLimdsOthers(String lowerLimdsOthers) {
        this.lowerLimdsOthers = lowerLimdsOthers;
    }

    @Column(name = "diognes_disabilitesMotor",nullable = false)
    public boolean isDisabilitesMotor() {
        return disabilitesMotor;
    }

    public void setDisabilitesMotor(boolean disabilitesMotor) {
        this.disabilitesMotor = disabilitesMotor;
    }

    @Column(name = "diognes_hearing",nullable = false)
    public boolean isHearing() {
        return hearing;
    }

    public void setHearing(boolean hearing) {
        this.hearing = hearing;
    }

    @Column(name = "diognes_visual",nullable = false)
    public boolean isVisual() {
        return visual;
    }

    public void setVisual(boolean visual) {
        this.visual = visual;
    }

    @Column(name = "diognes_mental",nullable = false)
    public boolean isMental() {
        return mental;
    }

    public void setMental(boolean mental) {
        this.mental = mental;
    }

    @Column(name = "diognes_psychic",nullable = false)
    public boolean isPsychic() {
        return psychic;
    }

    public void setPsychic(boolean psychic) {
        this.psychic = psychic;
    }

    @Column(name = "diognes_autism",nullable = false)
    public boolean isAutism() {
        return autism;
    }

    public void setAutism(boolean autism) {
        this.autism = autism;
    }

    @Column(name = "diognes_learningDisabilities",nullable = false)
    public boolean isLearningDisabilities() {
        return learningDisabilities;
    }

    public void setLearningDisabilities(boolean learningDisabilities) {
        this.learningDisabilities = learningDisabilities;
    }

    @Column(name = "diognes_possiblecause",nullable = true)
    public String getPossibleCause() {
        return possibleCause;
    }

    public void setPossibleCause(String possibleCause) {
        this.possibleCause = possibleCause;
    }

    @Column(name = "diognes_deformities",nullable = false)
    public String getDeformities() {
        return Deformities;
    }

    public void setDeformities(String Deformities) {
        this.Deformities = Deformities;
    }

    @Column(name = "diognes_neurologicalMotor",nullable = true)
    public String getNeurologicalMotor() {
        return neurologicalMotor;
    }

    public void setNeurologicalMotor(String neurologicalMotor) {
        this.neurologicalMotor = neurologicalMotor;
    }

    @Column(name = "diognes_neurologicalSensory",nullable = true)
    public String getNeurologicalSensory() {
        return neurologicalSensory;
    }

    public void setNeurologicalSensory(String neurologicalSensory) {
        this.neurologicalSensory = neurologicalSensory;
    }

    @Column(name = "diognes_neurologicalOther",nullable = true)
    public String getNeurologicalOthers() {
        return neurologicalOthers;
    }

    public void setNeurologicalOthers(String neurologicalOthers) {
        this.neurologicalOthers = neurologicalOthers;
    }

    @Column(name = "diognes_eyeAcuityTR",nullable = true)
    public String getEyesAcuityTR() {
        return eyesAcuityTR;
    }

    public void setEyesAcuityTR(String eyesAcuityTR) {
        this.eyesAcuityTR = eyesAcuityTR;
    }

    @Column(name = "diognes_eyesAcuityTL",nullable = true)
    public String getEyesAcuityTL() {
        return eyesAcuityTL;
    }

    public void setEyesAcuityTL(String eyesAcuityTL) {
        this.eyesAcuityTL = eyesAcuityTL;
    }

    @Column(name = "diognes_eyesAcuityBR",nullable = true)
    public String getEyesAcuityBR() {
        return eyesAcuityBR;
    }

    public void setEyesAcuityBR(String eyesAcuityBR) {
        this.eyesAcuityBR = eyesAcuityBR;
    }

    @Column(name = "diognes_acuityBL",nullable = true)
    public String getEyesAcuityBL() {
        return eyesAcuityBL;
    }

    public void setEyesAcuityBL(String eyesAcuityBL) {
        this.eyesAcuityBL = eyesAcuityBL;
    }

    @Column(name = "diognes_eyesMovementR",nullable = true)
    public String getEyesMovementR() {
        return eyesMovementR;
    }

    public void setEyesMovementR(String eyesMovementR) {
        this.eyesMovementR = eyesMovementR;
    }

    @Column(name = "diognes_eyesMovementL",nullable = true)
    public String getEyesMovementL() {
        return eyesMovementL;
    }

    public void setEyesMovementL(String eyesMovementL) {
        this.eyesMovementL = eyesMovementL;
    }

    @Column(name = "diognes_eyesCorneaR",nullable = true)
    public String getEyesCorneaR() {
        return eyesCorneaR;
    }

    public void setEyesCorneaR(String eyesCorneaR) {
        this.eyesCorneaR = eyesCorneaR;
    }

    @Column(name = "diognes_eyesCorneaL",nullable = true)
    public String getEyesCorneaL() {
        return eyesCorneaL;
    }

    public void setEyesCorneaL(String eyesCorneaL) {
        this.eyesCorneaL = eyesCorneaL;
    }

    @Column(name = "diognes_eyesPupilR",nullable = true)
    public String getEyesPupilR() {
        return eyesPupilR;
    }

    public void setEyesPupilR(String eyesPupilR) {
        this.eyesPupilR = eyesPupilR;
    }

    @Column(name = "diognes_eyesPupilL",nullable = true)
    public String getEyesPupilL() {
        return eyesPupilL;
    }

    public void setEyesPupilL(String eyesPupilL) {
        this.eyesPupilL = eyesPupilL;
    }

    @Column(name = "diognes_eyesComment",nullable = true)
    public String getEyesComment() {
        return eyesComment;
    }

    public void setEyesComment(String eyesComment) {
        this.eyesComment = eyesComment;
    }

    @Column(name = "diognes_HearingR",nullable = true)
    public String getHearingR() {
        return hearingR;
    }

    public void setHearingR(String hearingR) {
        this.hearingR = hearingR;
    }

    @Column(name = "diognes_hearingL",nullable = true)
    public String getHearingL() {
        return hearingL;
    }

    public void setHearingL(String hearingL) {
        this.hearingL = hearingL;
    }

    @Column(name = "diognes_nose",nullable = false)
    public boolean isNose() {
        return nose;
    }

    public void setNose(boolean nose) {
        this.nose = nose;
    }

    @Column(name = "diognes_earDischargeR",nullable = true)
    public String getEarDischargeR() {
        return earDischargeR;
    }

    public void setEarDischargeR(String earDischargeR) {
        this.earDischargeR = earDischargeR;
    }

    @Column(name = "diognes_dischargeL",nullable = true)
    public String getEarDischargeL() {
        return earDischargeL;
    }

    public void setEarDischargeL(String earDischargeL) {
        this.earDischargeL = earDischargeL;
    }

    @Column(name = "diognes_throat",nullable = false)
    public boolean isThroat() {
        return throat;
    }

    public void setThroat(boolean throat) {
        this.throat = throat;
    }

    @Column(name = "diognes_comments",nullable = true)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "diognes_nutritionalRiskAssessment",nullable = false)
    public boolean isNutritionalRiskAssessment() {
        return nutritionalRiskAssessment;
    }

    public void setNutritionalRiskAssessment(boolean nutritionalRiskAssessment) {
        this.nutritionalRiskAssessment = nutritionalRiskAssessment;
    }

    @Column(name = "diognes_nutritionalAssessmentComment",nullable = true)
    public String getNutritionalRiskAssessmentComment() {
        return nutritionalRiskAssessmentComment;
    }

    public void setNutritionalRiskAssessmentComment(String nutritionalRiskAssessmentComment) {
        this.nutritionalRiskAssessmentComment = nutritionalRiskAssessmentComment;
    }

    @Column(name = "diognes_FunctionalRehabilitationAssessment",nullable = true)
    public String getFunctionalRehabilitationAssessment() {
        return functionalRehabilitationAssessment;
    }

    public void setFunctionalRehabilitationAssessment(String functionalRehabilitationAssessment) {
        this.functionalRehabilitationAssessment = functionalRehabilitationAssessment;
    }

    @Column(name = "diognes_FallRiskAssessment",nullable = true)
    public String getFallRiskAssessment() {
        return fallRiskAssessment;
    }

    public void setFallRiskAssessment(String fallRiskAssessment) {
        this.fallRiskAssessment = fallRiskAssessment;
    }

    @Column(name = "diognes_RiskForDM",nullable = false)
    public boolean isRiskForDM() {
        return riskForDM;
    }

    public void setRiskForDM(boolean riskForDM) {
        this.riskForDM = riskForDM;
    }

    @Column(name = "diognes_RiskForHypertension",nullable = false)
    public boolean isRiskForHypertension() {
        return riskForHypertension;
    }

    public void setRiskForHypertension(boolean riskForHypertension) {
        this.riskForHypertension = riskForHypertension;
    }

    @Column(name = "diognes_RiskForOthers",nullable = false)
    public boolean isRiskForOthers() {
        return riskForOthers;
    }

    public void setRiskForOthers(boolean riskForOthers) {
        this.riskForOthers = riskForOthers;
    }

    @Column(name = "diognes_RiskForComments",nullable = false)
    public boolean isRiskForComments() {
        return riskForComments;
    }

    public void setRiskForComments(boolean riskForComments) {
        this.riskForComments = riskForComments;
    }

    @Column(name = "diognes_Conclusion",nullable = false)
    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

	@Override
	public String toString() {
		return "diognes [id=" + id + ", date=" + date + ", preature=" + preature + ", pulse=" + pulse + ", temperature="
				+ temperature + ", BMI=" + BMI + ", gemeralApperance=" + gemeralApperance + ", facialExpression="
				+ facialExpression + ", painAssessment=" + painAssessment + ", pallor=" + pallor + ", cyanosis="
				+ cyanosis + ", jaundice=" + jaundice + ", hairDistibution=" + hairDistibution + ", unexpectedBruise="
				+ unexpectedBruise + ", Scars=" + Scars + ", veins=" + veins + ", stiffness=" + stiffness + ", thyroid="
				+ thyroid + ", lNodes=" + lNodes + ", headNeckOthers=" + headNeckOthers + ", headSutures=" + headSutures
				+ ", headFontanels=" + headFontanels + ", expansion=" + expansion + ", breathingSounds="
				+ breathingSounds + ", advSounds=" + advSounds + ", breast=" + breast + ", chestComments="
				+ chestComments + ", heartSounds=" + heartSounds + ", murmurs=" + murmurs + ", heartOthers="
				+ heartOthers + ", liver=" + liver + ", spleen=" + spleen + ", kidneys=" + kidneys + ", ascites="
				+ ascites + ", ascitesNote=" + ascitesNote + ", masses=" + masses + ", abdomenOthers=" + abdomenOthers
				+ ", extGenetalia=" + extGenetalia + ", upperLimdstremors=" + upperLimdstremors
				+ ", upperLimdsclubbing=" + upperLimdsclubbing + ", upperLimdsjoints=" + upperLimdsjoints
				+ ", upperLimdsOthers=" + upperLimdsOthers + ", lowerLimbsOdema=" + lowerLimbsOdema
				+ ", lowerLimdsclubbing=" + lowerLimdsclubbing + ", lowerLimdsjoints=" + lowerLimdsjoints
				+ ", lowerLimdsOthers=" + lowerLimdsOthers + ", disabilitesMotor=" + disabilitesMotor + ", hearing="
				+ hearing + ", visual=" + visual + ", mental=" + mental + ", psychic=" + psychic + ", autism=" + autism
				+ ", learningDisabilities=" + learningDisabilities + ", possibleCause=" + possibleCause
				+ ", Deformities=" + Deformities + ", neurologicalMotor=" + neurologicalMotor + ", neurologicalSensory="
				+ neurologicalSensory + ", neurologicalOthers=" + neurologicalOthers + ", eyesAcuityTR=" + eyesAcuityTR
				+ ", eyesAcuityTL=" + eyesAcuityTL + ", eyesAcuityBR=" + eyesAcuityBR + ", eyesAcuityBL=" + eyesAcuityBL
				+ ", eyesMovementR=" + eyesMovementR + ", eyesMovementL=" + eyesMovementL + ", eyesCorneaR="
				+ eyesCorneaR + ", eyesCorneaL=" + eyesCorneaL + ", eyesPupilR=" + eyesPupilR + ", eyesPupilL="
				+ eyesPupilL + ", eyesComment=" + eyesComment + ", hearingR=" + hearingR + ", hearingL=" + hearingL
				+ ", nose=" + nose + ", earDischargeR=" + earDischargeR + ", earDischargeL=" + earDischargeL
				+ ", throat=" + throat + ", comments=" + comments + ", nutritionalRiskAssessment="
				+ nutritionalRiskAssessment + ", nutritionalRiskAssessmentComment=" + nutritionalRiskAssessmentComment
				+ ", functionalRehabilitationAssessment=" + functionalRehabilitationAssessment + ", fallRiskAssessment="
				+ fallRiskAssessment + ", riskForDM=" + riskForDM + ", riskForHypertension=" + riskForHypertension
				+ ", riskForOthers=" + riskForOthers + ", riskForComments=" + riskForComments + ", conclusion="
				+ conclusion + ", doctor=" + doctor + ", patient=" + patient + ", treaments=" + treaments
				+ ", medicalAdvicesList=" + medicalAdvicesList + ", disease=" + disease + "]";
	}
    
    
    

}
