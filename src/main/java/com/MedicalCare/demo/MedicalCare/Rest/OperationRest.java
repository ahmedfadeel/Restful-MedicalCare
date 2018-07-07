package com.MedicalCare.demo.MedicalCare.Rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.MedicalCare.demo.MedicalCare.Entities.Operation;
import com.MedicalCare.demo.MedicalCare.Service.OperationService;

@RestController
@RequestMapping(value="operation")
public class OperationRest {

	@Autowired
	OperationService operationService;
	
	@RequestMapping(value= "/add",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE ,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Object> addOperation(@Valid @RequestBody Operation operation){
		long id = operationService.addOperation(operation);
		
		return new ResponseEntity("Added Successfully!",HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/doctorID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDoctorOperations(@PathVariable long id){
		
		List<Operation> operations = operationService.getDoctorOperations(id);
		
		if(operations==null||operations.size()==0) {
			return new ResponseEntity<String>("there is no operations to this doctor",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Operation>>(operations,HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value = "/patientID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPatientOperations(@PathVariable long id){
		
		List<Operation> operations = operationService.getPatientOperations(id);
		
		if(operations==null||operations.size()==0) {
			return new ResponseEntity<String>("there is no operations to this patient",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Operation>>(operations,HttpStatus.OK);
		}
		
	}
}
