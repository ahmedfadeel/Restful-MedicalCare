package com.MedicalCare.demo.MedicalCare.Rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.print.Doc;
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

import com.MedicalCare.demo.MedicalCare.Entities.Address;
import com.MedicalCare.demo.MedicalCare.Entities.Analysis;
import com.MedicalCare.demo.MedicalCare.Entities.Doctor;
import com.MedicalCare.demo.MedicalCare.Service.DoctorService;

@RestController
@RequestMapping(value="/doctor")
public class DoctorRest {

	@Autowired
	DoctorService doctorService;
	private final String imageSequer = "25712kh55ui";
	
	@RequestMapping(value= "/add",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE ,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity addDoctor(@Valid @RequestBody Doctor doctor) {
		
		long id = doctorService.addDoctor(doctor);
		
		
		return new ResponseEntity("Added Successfully!",HttpStatus.OK);
		
	}
	@RequestMapping(value="/add/image",method=RequestMethod.POST)
	public ResponseEntity uploadImage(@RequestParam Long id,HttpServletResponse response , HttpServletRequest request) {
		try {
			Doctor doctor = doctorService.getDoctor(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+imageSequer+".png";
			String path = "src/main/resources/static/image/profiles/"+fileName;
			
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(new File(path)));
			buffer.write(bytes);
			buffer.close();
			
			doctor.setImagePath(path);
			doctorService.updateDoctor(doctor);
			
			return new ResponseEntity<String>("uploaded sucessfully!",HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String> ("upload Failed !",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/update/image",method=RequestMethod.POST)
	public ResponseEntity updateImage(@RequestParam Long id,HttpServletResponse response , HttpServletRequest request) {
		try {
			Doctor doctor = doctorService.getDoctor(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+".png";
			String path = "src/main/resources/static/image/profiles/"+fileName;
			
			Files.delete(Paths.get(doctor.getImagePath()));
			
			
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(new File(path)));
			buffer.write(bytes);
			buffer.close();
			
			doctor.setImagePath(path);
			doctorService.updateDoctor(doctor);
			return new ResponseEntity<String>("uploaded sucessfully!",HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String> ("upload Failed !",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
	
	@RequestMapping(value= "/update/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE ,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Object> updateDoctor(@PathVariable long id,@Valid @RequestBody Doctor doctor){
	
		doctor.setId(id);
		doctorService.updateDoctor(doctor);
		
		return new ResponseEntity("Updated Successfully!",HttpStatus.OK);

	}
	
	
	@RequestMapping(value="/hospitalID/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getDoctorsOfHospital(@PathVariable int id){
		List<Doctor> doctors = doctorService.getDoctorsOfHospital(id);
		
		if(doctors==null||doctors.size()==0) {
			return new ResponseEntity<String>("there is no doctors at this hospital",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Doctor>>(doctors,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/doctorID/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getDoctor(@PathVariable long id){
		Doctor doctor = doctorService.getDoctor(id);
		if(doctor==null) {
			return new ResponseEntity<String>("there is no doctor with this id",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
		}
	}
	@RequestMapping(value="/patientID/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getPatientDoctors(@PathVariable long id){
List<Doctor> doctors = doctorService.getPatientDoctors(id);
		
		if(doctors==null||doctors.size()==0) {
			return new ResponseEntity<String>("there is no doctors to this patient",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Doctor>>(doctors,HttpStatus.OK);
		}
	}
	@RequestMapping(value="/doctorName/{doctorName}",method=RequestMethod.GET)
	public ResponseEntity<?> getDoctorByName(@PathVariable String doctorName){
List<Doctor> doctors = doctorService.getDoctorByName(doctorName);
		
		if(doctors.size()==0) {
			return new ResponseEntity<String>("there is no doctors with this name",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Doctor>>(doctors,HttpStatus.OK);
		}
	}
	@RequestMapping(value="/clinkGovernment/{goverment}/clinkCity/{city}",method=RequestMethod.GET)
	public ResponseEntity<?> getDoctorsByClinicAddress(@PathVariable String goverment,@PathVariable String city ){
		Address address = new Address();
		address.setCity(city);
		address.setGoverment(goverment);
		System.out.println("********************************************************");
		
      List<Doctor> doctors = doctorService.getDoctorsByClinicAddress(address);
		
		if(doctors==null||doctors.size()==0) {
			return new ResponseEntity<String>("there is no doctors with this clink address",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Doctor>>(doctors,HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(value="/doctorDepartment/{doctorDepartment}",method=RequestMethod.GET)
	public ResponseEntity<?> getDoctorsByDerartment(@PathVariable String doctorDepartment){
List<Doctor> doctors = doctorService.getDoctorsByDerartment(doctorDepartment);
		
		if(doctors==null||doctors.size()==0) {
			return new ResponseEntity<String>("there is no doctors with this department",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Doctor>>(doctors,HttpStatus.OK);
		}
	}
	
}
