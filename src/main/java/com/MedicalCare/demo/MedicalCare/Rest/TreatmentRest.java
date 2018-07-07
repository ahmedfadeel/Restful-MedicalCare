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

import com.MedicalCare.demo.MedicalCare.Entities.Treatment;
import com.MedicalCare.demo.MedicalCare.Entities.TreatmentAnalyist;
import com.MedicalCare.demo.MedicalCare.Service.TreatmentService;

@RestController
@RequestMapping(value="treatments")
public class TreatmentRest {

	@Autowired
	TreatmentService treatmentService;
	
	@RequestMapping(value= "/add",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE ,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Object> addTreatment(@Valid @RequestBody Treatment treatment){
		
		long id = treatmentService.addTreatment(treatment);
		
		return new ResponseEntity("Added Successfully!",HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/diognesID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDiognesTreatments(@PathVariable long id){
		List<Treatment> treatments = treatmentService.getDiognesTreatments(id);
		
		if(treatments==null||treatments.size()==0) {
			return new ResponseEntity<String>("there is no treatments to this diogneses",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Treatment>>(treatments,HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/TreatmentAnalyst/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getTratmentAnalyst(@PathVariable String name){
		TreatmentAnalyist treatments = treatmentService.getTratmentAnalysit(name);
		
		if(treatments==null) {
			return new ResponseEntity<String>("there is no treatments by this name",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity <TreatmentAnalyist>(treatments,HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/TreatmentAnalysts", method = RequestMethod.GET)
	public ResponseEntity<?> getAllTratmentAnalyst(){
		List<TreatmentAnalyist> treatments = treatmentService.getTratmentAnalysit();
		
		if(treatments==null) {
			return new ResponseEntity<String>("there is no treatments",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity <List<TreatmentAnalyist>> (treatments,HttpStatus.OK);
		}
	}
	
}
