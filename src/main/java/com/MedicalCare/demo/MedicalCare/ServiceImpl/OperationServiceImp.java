package com.MedicalCare.demo.MedicalCare.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalCare.demo.MedicalCare.Dao.OperationDao;
import com.MedicalCare.demo.MedicalCare.Entities.Hospital;
import com.MedicalCare.demo.MedicalCare.Entities.Operation;
import com.MedicalCare.demo.MedicalCare.Service.OperationService;

@Service
public class OperationServiceImp implements OperationService {

	@Autowired
	OperationDao operationDao;

	@Override
	public long addOperation(Operation operation) {
		return operationDao.addOperation(operation);
		
	}

	@Override
	public List<Operation> getDoctorOperations(long doctorID) {
		return operationDao.getDoctorOperations(doctorID);
	}

	@Override
	public List<Operation> getPatientOperations(long patientID) {
		return operationDao.getPatientOperations(patientID);
	}

	
}
