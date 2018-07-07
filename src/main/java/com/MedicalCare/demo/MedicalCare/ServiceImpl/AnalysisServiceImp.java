package com.MedicalCare.demo.MedicalCare.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalCare.demo.MedicalCare.Dao.AnalysisDao;
import com.MedicalCare.demo.MedicalCare.Entities.Analysis;
import com.MedicalCare.demo.MedicalCare.Service.AnalysisService;

@Service
public class AnalysisServiceImp implements AnalysisService{

	
	@Autowired
	AnalysisDao analysisDao;
	@Override
	public void addAnalysis(Analysis analysis) {

		analysisDao.addAnalysis(analysis);
		
	}

	@Override
	public List<Analysis> getPatientAnalysises(long patientID) {
		return analysisDao.getPatientAnalysises(patientID);
	}

	@Override
	public List<Analysis> getDiognesesByDoctorID(long doctorID) {
		return analysisDao.getDiognesesByDoctorID(doctorID);
	}

	@Override
	public List<Analysis> getDoctorToPatientDiogneses(long doctorID, long patientID) {
		return analysisDao.getDoctorToPatientDiogneses(doctorID, patientID);
	}

	@Override
	public Analysis getAnalysis(Long id) {
		return analysisDao.getAnalysis(id);
	}

}
