package com.MedicalCare.demo.MedicalCare.Dao;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.Treatment;

public interface TreatmentDao {
	
	public long addTreatment(Treatment treatment);
	public List<Treatment> getDiognesTreatments(long diognesID);
	public List<Treatment> getTreatmentByName(String name);
	public List<Treatment> getAll();

}
