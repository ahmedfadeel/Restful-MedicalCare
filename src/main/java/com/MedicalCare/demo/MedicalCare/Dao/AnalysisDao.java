package com.MedicalCare.demo.MedicalCare.Dao;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.Analysis;

public interface AnalysisDao {
	
	public void addAnalysis(Analysis analysis);
	public Analysis getAnalysis(Long id);
	public List<Analysis> getPatientAnalysises(long patientID);
	public List<Analysis> getDiognesesByDoctorID(long doctorID);
	public List<Analysis> getDoctorToPatientDiogneses(long doctorID, long patientID);
	
}
