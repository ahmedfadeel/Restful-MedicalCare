package com.MedicalCare.demo.MedicalCare.Service;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.Disease;

public interface DiseaseService {
	public int addDisease(Disease disease);
	public void deleteDisease(int diseaseID);
	public List<Disease> getPatientDiseases(long id);
	public Disease getDisease(int diseaseID);

}
