package com.MedicalCare.demo.MedicalCare.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MedicalCare.demo.MedicalCare.Dao.OperationDao;
import com.MedicalCare.demo.MedicalCare.Entities.Doctor;
import com.MedicalCare.demo.MedicalCare.Entities.Operation;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;

@Transactional
@Component
public class OperationDaoImp implements OperationDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long addOperation(Operation operation) {
		 Session session = sessionFactory.openSession();
		 long id = 0;
	        try {
	            id = (long) session.save(operation);
	        } catch (HibernateException e) {
	            
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return id;
		
	}

	@Override
	public List<Operation> getDoctorOperations(long doctorID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
//        String hql = "from operation where doc_id = ?";
//        Query query = session.createQuery(hql).setLong(0, doctorID);
//        results = query.list();
    	   Doctor doctor = session.get(Doctor.class, doctorID);
    	   if(doctor!=null) {
    	   results = doctor.getOperations();
    	   }
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

	@Override
	public List<Operation> getPatientOperations(long patientID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
//        String hql = "from operation where pat_id = ?";
//        Query query = session.createQuery(hql).setLong(0, patientID);
//        results = query.list();
    	   Patient patient = session.get(Patient.class, patientID);
    	   if(patient!=null) {
    	   results=patient.getOperations();
    	   }
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

}
