package com.MedicalCare.demo.MedicalCare.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalCare.demo.MedicalCare.Dao.DoctorDao;
import com.MedicalCare.demo.MedicalCare.Entities.Address;
import com.MedicalCare.demo.MedicalCare.Entities.Analysis;
import com.MedicalCare.demo.MedicalCare.Entities.Doctor;
import com.MedicalCare.demo.MedicalCare.Entities.Operation;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;
import com.MedicalCare.demo.MedicalCare.Entities.diognes;
import com.MedicalCare.demo.MedicalCare.Service.DoctorService;

@Service
public class DoctorServiceImp implements DoctorService {

	@Autowired
	DoctorDao doctorDao;
	@Override
	public long addDoctor(Doctor doctor) {
		doctor.setAnalysises(new ArrayList<Analysis>());
		doctor.setDioList(new ArrayList<diognes>());
		doctor.setOperations(new ArrayList<Operation>());
		doctor.setPatients(new ArrayList<Patient>());
		return doctorDao.addDoctor(doctor);
		
	}

	@Override
	public void updateImage(long doctorId, byte[] newImage) {
		doctorDao.updateImage(doctorId, newImage);
		
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		doctorDao.updateDoctor(doctor);
		
	}

	@Override
	public List<Doctor> getDoctorsOfHospital(int hospitalId) {
		
		return doctorDao.getDoctorsOfHospital(hospitalId);
	}

	@Override
	public Doctor getDoctor(long doctorID) {
		// TODO Auto-generated method stub
		return doctorDao.getDoctor(doctorID);
	}

	@Override
	public List<Doctor> getPatientDoctors(long patientID) {
		// TODO Auto-generated method stub
		return doctorDao.getPatientDoctors(patientID);
	}

	@Override
	public List<Doctor> getDoctorByName(String doctorName) {
		// TODO Auto-generated method stub
		return doctorDao.getDoctorByName(doctorName);
	}

	@Override
	public List<Doctor> getDoctorsByClinicAddress(Address clinicAddress) {
		// TODO Auto-generated method stub
		return doctorDao.getDoctorsByClinicAddress(clinicAddress);
	}

	@Override
	public List<Doctor> getDoctorsByDerartment(String doctorDepartment) {
		// TODO Auto-generated method stub
		return doctorDao.getDoctorsByDerartment(doctorDepartment);
	}

}
