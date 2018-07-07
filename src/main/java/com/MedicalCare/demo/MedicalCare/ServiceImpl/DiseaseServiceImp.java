package com.MedicalCare.demo.MedicalCare.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalCare.demo.MedicalCare.Dao.DiseaseDao;
import com.MedicalCare.demo.MedicalCare.Entities.Disease;
import com.MedicalCare.demo.MedicalCare.Entities.MedicalAdvice;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;
import com.MedicalCare.demo.MedicalCare.Entities.diognes;
import com.MedicalCare.demo.MedicalCare.Service.DiseaseService;

@Service
public class DiseaseServiceImp implements DiseaseService {
	
	@Autowired
	DiseaseDao diseaseDao;

	@Override
	public int addDisease(Disease disease) {
		
		disease.setDioList(new ArrayList<diognes>());
		disease.setMedicalAdviceList(new ArrayList<MedicalAdvice>());
		disease.setPatientsList(new ArrayList<Patient>());

		return diseaseDao.addDisease(disease);
	}

	@Override
	public void deleteDisease(int diseaseID) {

		diseaseDao.deleteDisease(diseaseID);
	}

	@Override
	public List<Disease> getPatientDiseases(long patientID) {
		return diseaseDao.getPatientDiseases(patientID);
	}

	@Override
	public Disease getDisease(int diseaseID) {
		return diseaseDao.getDisease(diseaseID);
	}

}
