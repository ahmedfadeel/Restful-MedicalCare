package com.MedicalCare.demo.MedicalCare.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalCare.demo.MedicalCare.Dao.MedicalAdviceDao;
import com.MedicalCare.demo.MedicalCare.Entities.MedicalAdvice;
import com.MedicalCare.demo.MedicalCare.Service.MedicalAdviceService;

@Service
public class MedicalAdviceServiceImp implements MedicalAdviceService{

	@Autowired
	MedicalAdviceDao medicalAdviceDao;

	@Override
	public long addMedicalAdvice(MedicalAdvice ma) {
		return medicalAdviceDao.addMedicalAdvice(ma);
		
	}

	@Override
	public List<MedicalAdvice> getDiseasesAdvices(int diseasesID) {
		return medicalAdviceDao.getDiseasesAdvices(diseasesID);
	}

	@Override
	public List<MedicalAdvice> getDiognesAdvices(long diognesID) {
		return medicalAdviceDao.getDiognesAdvices(diognesID);
	}
}
