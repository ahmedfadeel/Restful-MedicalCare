package com.MedicalCare.demo.MedicalCare.Dao;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.MedicalAdvice;

public interface MedicalAdviceDao {

	public long addMedicalAdvice(MedicalAdvice ma);
	public List<MedicalAdvice> getDiseasesAdvices(int diseasesID);
	public List<MedicalAdvice> getDiognesAdvices(long diognesID);
	
}
