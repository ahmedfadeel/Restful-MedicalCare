package com.MedicalCare.demo.MedicalCare.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalCare.demo.MedicalCare.Dao.DiognesesDao;
import com.MedicalCare.demo.MedicalCare.Dao.DoctorDao;
import com.MedicalCare.demo.MedicalCare.Dao.PatientDao;
import com.MedicalCare.demo.MedicalCare.Entities.diognes;
import com.MedicalCare.demo.MedicalCare.Service.DiognesesService;

@Service
public class DiognesesServiceImp implements DiognesesService {

	@Autowired
	DiognesesDao diognesesDao;
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	PatientDao patientDao;
	
	@Override
	public long addDiognes(diognes diognes) {
		
		diognes.getDoctor().getPatients().add(diognes.getPatient());
		diognes.getPatient().getDoctors().add(diognes.getDoctor());
		doctorDao.updateDoctor(diognes.getDoctor());
		patientDao.updatePatient(diognes.getPatient());
		
		return diognesesDao.addDiognes(diognes);
		
	}

	@Override
	public List<diognes> getDiognesByPatientID(long PatientID) {
		return diognesesDao.getDiognesByPatientID(PatientID);
	}

	@Override
	public List<diognes> getDiognesesByDoctorID(long doctorID) {
		return diognesesDao.getDiognesesByDoctorID(doctorID);
	}

	@Override
	public List<diognes> getDoctorToPatientDiogneses(long doctorID, long patientID) {
		return diognesesDao.getDoctorToPatientDiogneses(doctorID, patientID);
	}

	@Override
	public List<diognes> getDiognesesForPatientDisease(long patientID, int disesesID) {
		return diognesesDao.getDiognesesForPatientDisease(patientID, disesesID);
	}

	@Override
	public List<diognes> getDiognesesByDisesesID(int diseasesID) {
		return diognesesDao.getDiognesesByDisesesID(diseasesID);
	}

}
