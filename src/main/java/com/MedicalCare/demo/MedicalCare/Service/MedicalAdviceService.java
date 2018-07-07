package com.MedicalCare.demo.MedicalCare.Service;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.MedicalAdvice;

public interface MedicalAdviceService {

	public long addMedicalAdvice(MedicalAdvice ma);
	public List<MedicalAdvice> getDiseasesAdvices(int diseasesID);
	public List<MedicalAdvice> getDiognesAdvices(long diognesID);
}
