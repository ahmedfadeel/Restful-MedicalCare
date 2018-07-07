package com.MedicalCare.demo.MedicalCare.Dao;

import java.util.Date;
import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.diognes;

public interface DiognesesDao {

	public long addDiognes(diognes diognes);
	public List<diognes> getDiognesByPatientID(long patientID);
	public List<diognes> getDiognesesByDoctorID(long doctorID);
	public List<diognes> getDoctorToPatientDiogneses(long doctorID, long patientID);
	public List<diognes> getDiognesesForPatientDisease(long patientID, int disesesID);
	public List<diognes> getDiognesesByDisesesID(int diseasesID);
	public List<diognes> getDiognesesBetweenDates(Date start , Date end , long patientID);
}
