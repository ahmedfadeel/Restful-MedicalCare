package com.MedicalCare.demo.MedicalCare.Service;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.Hospital;

public interface HospitalService {

	public int addHospital(Hospital hospital);
	public void updateHospital(Hospital hospital);
	public Hospital getHospital(int hospitalID);
	public List<Hospital> getAllHospitals();
}
