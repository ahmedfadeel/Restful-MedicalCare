package com.MedicalCare.demo.MedicalCare.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalCare.demo.MedicalCare.Dao.HospitalDao;
import com.MedicalCare.demo.MedicalCare.Entities.Doctor;
import com.MedicalCare.demo.MedicalCare.Entities.Hospital;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;
import com.MedicalCare.demo.MedicalCare.Service.HospitalService;

@Service
public class HospitalServiceImp implements HospitalService {

	@Autowired
	HospitalDao hospitalDao;
	@Override
	public int addHospital(Hospital hospital) {
		hospital.setDoctors(new ArrayList<Doctor>());
		hospital.setHospitalPatients(new ArrayList<Patient>());
		return hospitalDao.addHospital(hospital);	
	}

	@Override
	public void updateHospital(Hospital hospital) {
		hospitalDao.updateHospital(hospital);
		
	}

	@Override
	public Hospital getHospital(int hospitalID) {
		return hospitalDao.getHospital(hospitalID);
	}

	@Override
	public List<Hospital> getAllHospitals() {
		return hospitalDao.getAllHospitals();
	}

}
