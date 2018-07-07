package com.MedicalCare.demo.MedicalCare.DaoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MedicalCare.demo.MedicalCare.Dao.DiognesesDao;
import com.MedicalCare.demo.MedicalCare.Entities.diognes;

@Transactional
@Component
public class DiognesesDaoImp implements DiognesesDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long addDiognes(diognes diognes) {
		Session session = sessionFactory.openSession();
		long id =0;
        try {
           id = (long) session.save(diognes);
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }
		return id;
	}

	@Override
	public List<diognes> getDiognesByPatientID(long PatientID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
        Query query = session.createQuery("from diognes where pat_id = ? ")
                .setLong(0, PatientID);
        results = query.list();
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

	@Override
	public List<diognes> getDiognesesByDoctorID(long doctorID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
        Query query = session.createQuery("from diognes where doc_id = ? ")
                .setLong(0, doctorID);
        results = query.list();
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

	@Override
	public List<diognes> getDoctorToPatientDiogneses(long doctorID, long patientID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
        Query query = session.createQuery("from diognes where doc_id = ? and pat_id = ? ")
                .setLong(0, doctorID)
                .setLong(1, patientID);
        results = query.list();
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

	@Override
	public List<diognes> getDiognesesForPatientDisease(long patientID, int disesesID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
        Query query = session.createQuery("from diognes where disease_id = ? and pat_id = ? ")
                .setInteger(0, disesesID)
                .setLong(1, patientID);
        results = query.list();
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

	@Override
	public List<diognes> getDiognesesByDisesesID(int diseasesID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
        Query query = session.createQuery("from diognes where disease_id = ? ")
                      .setInteger(0, diseasesID);
        results = query.list();
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;   
	}

	@Override
	public List<diognes> getDiognesesBetweenDates(Date start, Date end , long patientId) {

		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
        Query query = session.createQuery("from diognes where pat_id = ? and date Between ? and ? ")
                .setLong(0, patientId)
                .setDate(1, start)
                .setDate(2, end);
        results = query.list();
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

}
