package com.MedicalCare.demo.MedicalCare.Service;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.Hospital;
import com.MedicalCare.demo.MedicalCare.Entities.Operation;

public interface OperationService {

	public long addOperation(Operation operation);
	public List<Operation> getDoctorOperations(long doctorID);
	public List<Operation> getPatientOperations(long patientID);
}
