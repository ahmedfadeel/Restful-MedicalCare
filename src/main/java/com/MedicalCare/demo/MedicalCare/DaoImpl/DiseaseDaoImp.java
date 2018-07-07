package com.MedicalCare.demo.MedicalCare.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MedicalCare.demo.MedicalCare.Dao.DiseaseDao;
import com.MedicalCare.demo.MedicalCare.Entities.Disease;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;

@Transactional
@Component
public class DiseaseDaoImp implements DiseaseDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addDisease(Disease disease) {
		Session session = sessionFactory.openSession();
		int id=0;
        try {
           id = (int) session.save(disease);
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }	
        return id;
	}

	@Override
	public void deleteDisease(int diseaseID) {
		Session session = sessionFactory.openSession();
        Disease disease=null;
        try {
            disease=(Disease)session.get(Disease.class, diseaseID);
            session.delete(disease);
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

	@Override
	public List<Disease> getPatientDiseases(long patientID) {
		 Session session = sessionFactory.openSession();
	        List results = null;
	       try{
	      
	        Patient patient = (Patient) session.get(Patient.class, patientID);
	        if(patient!=null) {
	        results = patient.getDiseasesList();
	        }
	       }catch (HibernateException e) {
	             
	             e.printStackTrace();
	         } finally {
	             session.close();
	         }
	        
	        return results;
	}

	@Override
	public Disease getDisease(int diseaseID) {
		Session session = sessionFactory.openSession();
        Disease disease=null;
       
       try{
        disease=(Disease)session.get(Disease.class, diseaseID);
        
       
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        if (disease!=null) 
          return disease;
        return null;
	}

}
