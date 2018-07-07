package com.MedicalCare.demo.MedicalCare.Rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
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

import com.MedicalCare.demo.MedicalCare.Entities.Analysis;
import com.MedicalCare.demo.MedicalCare.Service.AnalysisService;

@RestController
@RequestMapping(value= {"/Analysis"})
public class AnalysisRest {
	
	@Autowired
	AnalysisService analysisService;

	@RequestMapping(value= "/add",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public void addAnalysis(@Valid @RequestBody Analysis analysis) {
		
		 analysisService.addAnalysis(analysis);
//		URI location = ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(analysisId).toUri();
//		return ResponseEntity.created(location).build();
		
	}
	@RequestMapping(value="/add/image",method=RequestMethod.POST)
	public ResponseEntity uploadImage(@RequestParam Long id,HttpServletResponse response , HttpServletRequest request) {
		try {
			Analysis analysis = analysisService.getAnalysis(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+""+analysis.getDoctor().getId()+""+".png";
			String path = "src/main/resources/static/image/analysis/"+fileName;
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(new File(path)));
			buffer.write(bytes);
			buffer.close();
			analysis.setPath(path);
			analysisService.addAnalysis(analysis);
			
			return new ResponseEntity<String>("uploaded sucessfully!",HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String> ("upload Failed !",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/patientID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPatientAnalysises(@PathVariable long id){
		
		List<Analysis> analysis = analysisService.getPatientAnalysises(id);
		if(analysis==null||analysis.size()==0) {
			return new ResponseEntity<String>("there is no Analysis to this Patient",
					HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity <List<Analysis>>(analysis,HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/DoctorID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDiognesesByDoctorID(@PathVariable int id){
		List<Analysis> analysis = analysisService.getDiognesesByDoctorID(id);
		if(analysis==null||analysis.size()==0) {
			return new ResponseEntity<String>("there is no Analysis to this Patient",
					HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity <List<Analysis>>(analysis,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/DoctorID/{doctorID}/PatientID/{patientID}", method = RequestMethod.GET)
	public ResponseEntity<?> getDoctorToPatientDiogneses(@PathVariable long doctorID, @PathVariable long patientID){
		
		List<Analysis> analysis = analysisService.getDoctorToPatientDiogneses(doctorID, patientID);
		if(analysis.size()==0) {
			return new ResponseEntity<String>("there is no Analysis to this Patient by this doctor",
					HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity <List<Analysis>>(analysis,HttpStatus.OK);
		}
	}
}
