package com.MedicalCare.demo.MedicalCare.Rest;

import java.net.URI;
import java.util.List;

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

import com.MedicalCare.demo.MedicalCare.Entities.Analysis;
import com.MedicalCare.demo.MedicalCare.Entities.diognes;
import com.MedicalCare.demo.MedicalCare.Service.DiognesesService;

@RestController
@RequestMapping(value="/diogneses")
public class DiognesesRest {

	@Autowired
	DiognesesService diognesesService;
	
	@RequestMapping(value= "/add",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE ,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Object> addDiognes(@RequestBody diognes diognes) {
		
           long diognesesId = diognesesService.addDiognes(diognes);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(diognesesId).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value="/patientID/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getDiognesByPatientID(@PathVariable long id){
		
		List<diognes> diognes = diognesesService.getDiognesByPatientID(id);
		
		if(diognes.size()==0) {
			return new ResponseEntity<String>("there is no diogneses to this Patient",
					HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity <List<diognes>>(diognes,HttpStatus.OK);
		}
		
	}
	
	
	
	@RequestMapping(value="/DoctorID/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getDiognesesByDoctorID(@PathVariable long id){
        List<diognes> diognes = diognesesService.getDiognesesByDoctorID(id);
		
		if(diognes.size()==0) {
			return new ResponseEntity<String>("there is no diogneses to this doctor",
					HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity <List<diognes>>(diognes,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/DoctorID/{doctorID}/PatientID/{patientID}",method=RequestMethod.GET)
	public ResponseEntity<?> getDoctorToPatientDiogneses(@PathVariable int doctorID,@PathVariable int patientID){
		
List<diognes> diognes = diognesesService.getDoctorToPatientDiogneses(doctorID, patientID);
		
		if(diognes.size()==0) {
			return new ResponseEntity<String>("there is no diogneses to this doctor for this Patient",
					HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity <List<diognes>>(diognes,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/PatientID/{patientID}/DiseaseID/{disesesID}",method=RequestMethod.GET)
	public ResponseEntity<?> getDiognesesForPatientDisease(@PathVariable int patientID,@PathVariable int disesesID){
List<diognes> diognes = diognesesService.getDiognesesForPatientDisease(patientID, disesesID);
		
		if(diognes.size()==0) {
			return new ResponseEntity<String>("there is no diogneses to this disease for this Patient",
					HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity <List<diognes>>(diognes,HttpStatus.OK);
		}		
	}
	
	@RequestMapping(value="/DiseaseID/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getDiognesesByDisesesID(@PathVariable int id){
		
       List<diognes> diognes = diognesesService.getDiognesesByDisesesID(id);
		
		if(diognes.size()==0) {
			return new ResponseEntity<String>("there is no diogneses to this disease",
					HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity <List<diognes>>(diognes,HttpStatus.OK);
		}
		
	}
}
