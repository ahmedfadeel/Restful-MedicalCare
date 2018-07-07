package com.MedicalCare.demo.MedicalCare.ServiceImpl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalCare.demo.MedicalCare.Dao.DiognesesDao;
import com.MedicalCare.demo.MedicalCare.Dao.TreatmentDao;
import com.MedicalCare.demo.MedicalCare.Entities.Disease;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;
import com.MedicalCare.demo.MedicalCare.Entities.Treatment;
import com.MedicalCare.demo.MedicalCare.Entities.TreatmentAnalyist;
import com.MedicalCare.demo.MedicalCare.Entities.diognes;
import com.MedicalCare.demo.MedicalCare.Service.TreatmentService;

@Service
public class TreatmentServiceImp implements TreatmentService {

	@Autowired
	TreatmentDao treatmentDao;
	
	@Autowired
	DiognesesDao diognesesDao;

	@Override
	public long addTreatment(Treatment treatment) {
		return treatmentDao.addTreatment(treatment);
		
	}

	@Override
	public List<Treatment> getDiognesTreatments(long diognesID) {
		return treatmentDao.getDiognesTreatments(diognesID);
	}

	@Override
	public TreatmentAnalyist getTratmentAnalysit(String name) {
		TreatmentAnalyist treatmentAnalyist = new TreatmentAnalyist();
		List<Treatment> treatments = treatmentDao.getTreatmentByName(name);
		if(treatments!=null&&treatments.size()!=0) {
		treatmentAnalyist.setTreatmentCount(treatments.size());
		long preatureCount=0;
		long sugarCount=0;
		long diognesesAfter=0;
		
		Date start = new Date();
	    Calendar cal = Calendar.getInstance();  
	    cal.setTime(start);  
	    cal.add(Calendar.DATE, 10); // 10 is the days you want to add or subtract   
	    Date end = cal.getTime();   
	    
		for(int i=0 ; i<treatments.size();i++ ) {
			Treatment treatment = treatments.get(i);
			Patient patient = treatment.getDiognes().getPatient();
			
			
		    List<diognes> diognes = diognesesDao.getDiognesesBetweenDates(start, end, patient.getId());
		    if(diognes!=null||diognes.size()!=0) {
		    
		    	diognesesAfter++;
		    }
			
			List<Disease> diseases = patient.getDiseasesList();
			for(int j=0;j<diseases.size();j++) {
				Disease disease = diseases.get(j);
				if(disease.getName().equals("sugar")) {
					sugarCount++;
				}else if(disease.getName().equals("blod preature")) {
					preatureCount++;
				}
			}
		}
		treatmentAnalyist.setPressurePatient(preatureCount);
		treatmentAnalyist.setSugarPatient(sugarCount);
		treatmentAnalyist.setDiognesesAfter(diognesesAfter);
		   
		return treatmentAnalyist;
		}else {
			return null;
		}
	}

	@Override
	public List<TreatmentAnalyist> getTratmentAnalysit() {

		ArrayList<String> names = new ArrayList<>();
		
		List<Treatment> treatments = treatmentDao.getAll();
		if(treatments!=null&&treatments.size()!=0) {
		String current = treatments.get(0).getName();
		names.add(current);
		
		for(int i=0;i<treatments.size();i++) {
			Treatment treatment = treatments.get(i);
			if(!treatment.getName().equalsIgnoreCase(current)) {
				current = treatment.getName();
				names.add(current);
			}
			
		}
		
		List<TreatmentAnalyist> treatmentAnalyists = new ArrayList<>();
		for(int i=0;i<names.size();i++) {
			TreatmentAnalyist treatmentAnalyist = getTratmentAnalysit(names.get(i));
			if(treatmentAnalyist!=null) {
				treatmentAnalyists.add(treatmentAnalyist);
			}
		}
		
		return treatmentAnalyists;
		}else {
			return null;
		}
	}
}
