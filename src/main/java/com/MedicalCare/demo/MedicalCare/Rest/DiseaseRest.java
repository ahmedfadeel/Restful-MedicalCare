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

import com.MedicalCare.demo.MedicalCare.Entities.Disease;
import com.MedicalCare.demo.MedicalCare.Service.DiseaseService;

@RestController
@RequestMapping(value="/disease")
public class DiseaseRest {

	@Autowired
	DiseaseService diseaseService;
	
	
	@RequestMapping(value= "/add",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE ,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Object> addDisease(@Valid @RequestBody Disease disease) {
		
		int diseaseId = diseaseService.addDisease(disease);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("diseaseID//{id}")
				.buildAndExpand(diseaseId).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@RequestMapping(value="/diseases/diseaseID/{id}",method=RequestMethod.DELETE)
	public void deleteDisease(@PathVariable int id) {
		diseaseService.deleteDisease(id);
	}
	
	
	@RequestMapping(value="/patientID/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getPatientDiseases(@PathVariable long id){
		List<Disease> diseases = diseaseService.getPatientDiseases(id);
		
		if(diseases==null||diseases.size()==0) {
			
			return new ResponseEntity<String>("there is no diseases to this Patient",
					HttpStatus.NOT_FOUND);
			
		}else {
			
			return new ResponseEntity<List<Disease>>(diseases,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/diseaseID/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getDisease(@PathVariable int id){
		Disease disease = diseaseService.getDisease(id);
		
		if(disease==null) {
			
			return new ResponseEntity<String>("there is no disease with this id",
					HttpStatus.NOT_FOUND);
			
		}else {
			
			return new ResponseEntity<Disease>(disease,HttpStatus.OK);
			
		}
	}

}
