package com.MedicalCare.demo.MedicalCare.Dao;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.Patient;

public interface PatientDao {
	
	public long addPatient(Patient patient);
	public void updatePatientImage(long patientId,byte[] newImage);
	public void updatePatient(Patient patient);
	public Patient getPatient(long patientID);
	public List<Patient> getPatientsWithDisease(int diseaseID);
	public List<Patient> getDoctorPatients(long doctorID);
	public List<Patient> getHospitalPatients(int HospitalID);
	
}
