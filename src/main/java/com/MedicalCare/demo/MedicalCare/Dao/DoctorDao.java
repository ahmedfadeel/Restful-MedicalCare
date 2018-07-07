package com.MedicalCare.demo.MedicalCare.Dao;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.Address;
import com.MedicalCare.demo.MedicalCare.Entities.Doctor;

public interface DoctorDao {
	
	public long addDoctor(Doctor doctor);
	public void updateImage(long doctorId, byte[] newImage);
	public void updateDoctor(Doctor doctor);
	public List<Doctor> getDoctorsOfHospital(int hospitalId);
	public Doctor getDoctor(long doctorID);
	public List<Doctor> getPatientDoctors(long patientID);
	public List<Doctor> getDoctorByName(String doctorName);
	public List<Doctor> getDoctorsByClinicAddress(Address clinicAddress);
	public List<Doctor> getDoctorsByDerartment(String doctorDepartment);
	

}
