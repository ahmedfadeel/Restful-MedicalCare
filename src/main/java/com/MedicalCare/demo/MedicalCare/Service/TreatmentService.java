package com.MedicalCare.demo.MedicalCare.Service;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.Treatment;
import com.MedicalCare.demo.MedicalCare.Entities.TreatmentAnalyist;

public interface TreatmentService {


	public long addTreatment(Treatment treatment);
	public List<Treatment> getDiognesTreatments(long diognesID);
	public TreatmentAnalyist getTratmentAnalysit(String name);
	public 	List<TreatmentAnalyist> getTratmentAnalysit();
	
	

}
