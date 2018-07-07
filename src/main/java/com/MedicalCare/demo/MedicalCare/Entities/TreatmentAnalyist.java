package com.MedicalCare.demo.MedicalCare.Entities;

public class TreatmentAnalyist {
	private String name;
	private long treatmentCount;
	private long SugarPatient;
	private long pressurePatient;
	private long diognesesAfter;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTreatmentCount() {
		return treatmentCount;
	}
	public void setTreatmentCount(long treatmentCount) {
		this.treatmentCount = treatmentCount;
	}
	public long getSugarPatient() {
		return SugarPatient;
	}
	public void setSugarPatient(long sugarPatient) {
		SugarPatient = sugarPatient;
	}
	public long getPressurePatient() {
		return pressurePatient;
	}
	public void setPressurePatient(long pressurePatient) {
		this.pressurePatient = pressurePatient;
	}
	public long getDiognesesAfter() {
		return diognesesAfter;
	}
	public void setDiognesesAfter(long diognesesAfter) {
		this.diognesesAfter = diognesesAfter;
	}
	
	

}
