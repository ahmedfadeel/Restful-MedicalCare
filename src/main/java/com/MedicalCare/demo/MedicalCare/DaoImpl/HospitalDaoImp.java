package com.MedicalCare.demo.MedicalCare.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MedicalCare.demo.MedicalCare.Dao.HospitalDao;
import com.MedicalCare.demo.MedicalCare.Entities.Hospital;

@Transactional
@Component
public class HospitalDaoImp implements HospitalDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int addHospital(Hospital hospital) {
		Session session = sessionFactory.openSession();
		
		int id = 0;
        try {
           id = (int) session.save(hospital);
        } catch (HibernateException e) {
           
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return id;
		
	}

	@Override
	public void updateHospital(Hospital hospital) {
		Session session = sessionFactory.openSession();
        try {
            session.update(hospital);
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }		
	}

	@Override
	public Hospital getHospital(int hospitalID) {
		Session session = sessionFactory.openSession();
        List results = null;
        Hospital hospital=null;
       
       try{
        hospital= (Hospital) session.get(Hospital.class, hospitalID);
        
              }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        if (hospital!=null) 
          return hospital;
        return null;
	}

	@Override
	public List<Hospital> getAllHospitals() {
		Session session = sessionFactory.openSession();
        List results = null;
       try{  
      
        String hql = "FROM Hospital ";
        Query query = session.createQuery(hql);
        
        results = query.list();
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

}
