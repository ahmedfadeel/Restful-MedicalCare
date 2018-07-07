package com.MedicalCare.demo.MedicalCare.Dao;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.Disease;

public interface DiseaseDao {

	public int addDisease(Disease disease);
	public void deleteDisease(int diseaseID);
	public List<Disease> getPatientDiseases(long patientID);
	public Disease getDisease(int diseaseID);
	
}
