package com.MedicalCare.demo.MedicalCare.Rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.MedicalCare.demo.MedicalCare.Entities.Doctor;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;
import com.MedicalCare.demo.MedicalCare.Entities.User;
import com.MedicalCare.demo.MedicalCare.Service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientRest {

	@Autowired
	PatientService patientService;
	private final String imageSequer = "25712kh55ui";

	
	@RequestMapping(value= "/add",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE ,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Object> addPatient(@Valid @RequestBody Patient patient){
		long id = patientService.addPatient(patient);
		
		return new ResponseEntity("Added Successfully!",HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/add/image",method=RequestMethod.POST)
	public ResponseEntity uploadImage(@RequestParam Long id,HttpServletResponse response , HttpServletRequest request) {
		try {
			Patient patient = patientService.getPatient(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+imageSequer+".png";
			String path = "src/main/resources/static/image/profiles/"+fileName;
			
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(new File(path)));
			buffer.write(bytes);
			buffer.close();
			
			patient.setImagePath(path);
			patientService.updatePatient(patient);
			
			return new ResponseEntity<String>("uploaded sucessfully!",HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String> ("upload Failed !",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/update/image",method=RequestMethod.POST)
	public ResponseEntity updateImage(@RequestParam Long id,HttpServletResponse response , HttpServletRequest request) {
		try {
			Patient doctor = patientService.getPatient(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+imageSequer+".png";
			String path = "src/main/resources/static/image/profiles/"+fileName;
			
			Files.delete(Paths.get(doctor.getImagePath()));
			
			
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(new File(path)));
			buffer.write(bytes);
			buffer.close();
			
			doctor.setImagePath(path);
			patientService.updatePatient(doctor);
			return new ResponseEntity<String>("uploaded sucessfully!",HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String> ("upload Failed !",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value= "/update",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE ,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Object> updatePatient(@Valid @RequestBody Patient patient){
		
		patientService.updatePatient(patient);
		
		return new ResponseEntity("Updated Successfully!",HttpStatus.OK);

	}
	
	@RequestMapping(value = "/patientID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPatient(@PathVariable long id) {
		
		Patient patient = patientService.getPatient(id);
		
		if(patient==null) {
			return new ResponseEntity<String>("patient Not Found !!",
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity <Patient>(patient, HttpStatus.OK);

		}
		
	}
	
	@RequestMapping(value = "/diseaseID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPatientsWithDisease(@PathVariable int id){
		List<Patient> patients = patientService.getPatientsWithDisease(id);
		if(patients==null||patients.size()==0) {
			return new ResponseEntity<String>("there is no patients to this disease ",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(value = "/doctorID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDoctorPatients(@PathVariable long id){
		
		List<Patient> patients = patientService.getDoctorPatients(id);
		if(patients==null||patients.size()==0) {
			return new ResponseEntity<String>("there is no patients to this doctor ",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);
		}
	}

	
	@RequestMapping(value = "/hospitalID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getHospitalPatients(@PathVariable int id){
		
		List<Patient> patients = patientService.getHospitalPatients(id);
		if(patients==null||patients.size()==0) {
			return new ResponseEntity<String>("there is no patients at this hospital ",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);
		}
	}
}
