package com.MedicalCare.demo.MedicalCare.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalCare.demo.MedicalCare.Dao.PatientDao;
import com.MedicalCare.demo.MedicalCare.Entities.Analysis;
import com.MedicalCare.demo.MedicalCare.Entities.Disease;
import com.MedicalCare.demo.MedicalCare.Entities.Doctor;
import com.MedicalCare.demo.MedicalCare.Entities.Hospital;
import com.MedicalCare.demo.MedicalCare.Entities.Operation;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;
import com.MedicalCare.demo.MedicalCare.Entities.diognes;
import com.MedicalCare.demo.MedicalCare.Service.PatientService;

@Service
public class PatientServiceImp implements PatientService{

	@Autowired
	PatientDao patientDao;

	@Override
	public long addPatient(Patient patient) {
		patient.setAnalysises(new ArrayList<Analysis>());
		patient.setDioList(new ArrayList<diognes>());
		patient.setDiseasesList(new ArrayList<Disease>());
		patient.setDoctors(new ArrayList<Doctor>());
		patient.setOperations(new ArrayList<Operation>());
		patient.setPatientHospitals(new ArrayList<Hospital>());
		return patientDao.addPatient(patient);
		
	}

	@Override
	public void updatePatientImage(long patientId, byte[] newImage) {
		patientDao.updatePatientImage(patientId, newImage);
		
	}

	@Override
	public void updatePatient(Patient patient) {
		patientDao.updatePatient(patient);
		
	}

	@Override
	public Patient getPatient(long patientID) {
		return patientDao.getPatient(patientID);
	}

	@Override
	public List<Patient> getPatientsWithDisease(int diseaseID) {
		return patientDao.getPatientsWithDisease(diseaseID);
	}

	@Override
	public List<Patient> getDoctorPatients(long doctorID) {
		return patientDao.getDoctorPatients(doctorID);
	}

	@Override
	public List<Patient> getHospitalPatients(int HospitalID) {
		return patientDao.getHospitalPatients(HospitalID);
	}
}
