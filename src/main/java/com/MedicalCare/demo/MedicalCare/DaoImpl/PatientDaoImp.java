package com.MedicalCare.demo.MedicalCare.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MedicalCare.demo.MedicalCare.Dao.PatientDao;
import com.MedicalCare.demo.MedicalCare.Entities.Disease;
import com.MedicalCare.demo.MedicalCare.Entities.Doctor;
import com.MedicalCare.demo.MedicalCare.Entities.Hospital;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;

@Transactional
@Component
public class PatientDaoImp implements PatientDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long addPatient(Patient patient) {
		Session session = sessionFactory.openSession();
		long id =0;
        try {
            id = (long) session.save(patient);
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
		
	}

	@Override
	public void updatePatientImage(long patientId, byte[] newImage) {
		Session session = sessionFactory.openSession();
        try {
     Query qry = session.createQuery("update Patient p set p.image=? where p.id=?"); 
                          
         qry.setParameter(0,newImage);
         qry.setParameter(1,patientId);
         int res = qry.executeUpdate();
            
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

	@Override
	public void updatePatient(Patient patient) {
		Session session = sessionFactory.openSession();
        try {
            session.update(patient);
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

	@Override
	public Patient getPatient(long patientID) {
		Session session = sessionFactory.openSession();
        Patient patient=null;
       
       try{
        patient=(Patient)session.get(Patient.class, patientID);

       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        if (patient!=null) 
          return patient;
        return null;
	}

	@Override
	public List<Patient> getPatientsWithDisease(int diseaseID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{      
        Disease disease = (Disease) session.get(Disease.class, diseaseID);
        if(disease!=null) {
        results = disease.getPatientsList();
        }
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

	@Override
	public List<Patient> getDoctorPatients(long doctorID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
        
    	   
        Doctor doctor = (Doctor) session.get(Doctor.class, doctorID);
        if(doctor!=null) {
        results=doctor.getPatients();
        }
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

	@Override
	public List<Patient> getHospitalPatients(int HospitalID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{      
           Hospital hospital = (Hospital) session.get(Hospital.class, HospitalID);
           if(hospital!=null) {
           results=hospital.getHospitalPatients();
           }
       }catch (HibernateException e) {
            
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

}
