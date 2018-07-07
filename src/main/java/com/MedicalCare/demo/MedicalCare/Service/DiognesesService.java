package com.MedicalCare.demo.MedicalCare.Service;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.diognes;

public interface DiognesesService {

	public long addDiognes(diognes diognes);
	public List<diognes> getDiognesByPatientID(long id);
	public List<diognes> getDiognesesByDoctorID(long id);
	public List<diognes> getDoctorToPatientDiogneses(long doctorID, long patientID);
	public List<diognes> getDiognesesForPatientDisease(long patientID, int disesesID);
	public List<diognes> getDiognesesByDisesesID(int diseasesID);
}
