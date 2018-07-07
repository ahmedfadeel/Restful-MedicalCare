package com.MedicalCare.demo.MedicalCare.Dao;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.Operation;

public interface OperationDao {

	public long addOperation(Operation operation);
	public List<Operation> getDoctorOperations(long doctorID);
	public List<Operation> getPatientOperations(long patientID);
	
}
