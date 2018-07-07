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

import com.MedicalCare.demo.MedicalCare.Entities.MedicalAdvice;
import com.MedicalCare.demo.MedicalCare.Service.MedicalAdviceService;

@RestController
@RequestMapping(value="medicalAdvice")
public class MedicalAdviceRest {

	@Autowired
	MedicalAdviceService medicalAdviceService;
	
	@RequestMapping(value= "/add",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE ,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Object> addMedicalAdvice(@Valid @RequestBody MedicalAdvice ma){
		
		long id = medicalAdviceService.addMedicalAdvice(ma);
		
		return new ResponseEntity("Added Successfully!",HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/diseasesID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDiseasesAdvices(@PathVariable int id){
		List<MedicalAdvice> medicalAdvices = medicalAdviceService.getDiseasesAdvices(id);
		
		if(medicalAdvices==null||medicalAdvices.size()==0) {
			return new ResponseEntity<String>("there is no advices to this disease",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<MedicalAdvice>>(medicalAdvices,HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/diognesID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDiognesAdvices(@PathVariable long id){

		List<MedicalAdvice> medicalAdvices = medicalAdviceService.getDiognesAdvices(id);
		
		if(medicalAdvices==null||medicalAdvices.size()==0) {
			return new ResponseEntity<String>("there is no advices to this diogneses",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<MedicalAdvice>>(medicalAdvices,HttpStatus.OK);
		}
	}
}
