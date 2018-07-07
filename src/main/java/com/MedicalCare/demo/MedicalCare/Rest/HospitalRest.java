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

import com.MedicalCare.demo.MedicalCare.Entities.Hospital;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;
import com.MedicalCare.demo.MedicalCare.Service.HospitalService;

@RestController
@RequestMapping("/hospital")
public class HospitalRest {

	@Autowired
	HospitalService hospitalService;
	
	
	@RequestMapping(value= "/add",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE ,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Object> addHospital(@Valid @RequestBody Hospital hospital){
		
		int id = hospitalService.addHospital(hospital);
		
		return new ResponseEntity("Added Successfully!",HttpStatus.OK);

		
	}
	
	@RequestMapping(value= "/update/{id}",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE ,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Object> updateHospital(@PathVariable int id,@Valid @RequestBody Hospital hospital){
		hospital.setId(id);
		hospitalService.updateHospital(hospital);
		
		return new ResponseEntity("Updated Successfully!",HttpStatus.OK);

	}
	
	
	@RequestMapping(value="/hospitalID/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getHospital(@PathVariable int id){
		Hospital hospital = hospitalService.getHospital(id);
		
		if(hospital==null) {
			
			return new ResponseEntity<String>("there is no hospital with this id",HttpStatus.NOT_FOUND);
			
		}else {
			
			return new ResponseEntity<Hospital>(hospital,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAllHospitals(){
		List<Hospital> hospitals = hospitalService.getAllHospitals();
		
		if(hospitals==null||hospitals.size()==0) {
			return new ResponseEntity<String>("users Not Found !!",
				HttpStatus.NOT_FOUND);
	} else {
		return new ResponseEntity <List<Hospital>>(hospitals, HttpStatus.OK);

	}
	}
}
