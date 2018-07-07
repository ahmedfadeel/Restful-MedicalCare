package com.MedicalCare.demo.MedicalCare.DaoImpl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MedicalCare.demo.MedicalCare.Dao.TreatmentDao;
import com.MedicalCare.demo.MedicalCare.Entities.Treatment;
import com.MedicalCare.demo.MedicalCare.Entities.diognes;

@Transactional
@Component
public class TreatmentDaoImp implements TreatmentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long addTreatment(Treatment treatment) {
		Session session = sessionFactory.openSession();
		long id=0;
        try {
            id=(long) session.save(treatment);
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }
		return id;
	}

	@Override
	public List<Treatment> getDiognesTreatments(long diognesID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
//        String hql = "from treaments where dio_id = ?";
//        Query query = session.createQuery(hql).setLong(0, diognesID);
//        results = query.list();
    	   diognes d = session.get(diognes.class, diognesID);
    	   if(d!=null) {
    	   results=d.getTreaments();
    	   }
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

	@Override
	public List<Treatment> getTreatmentByName(String name) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
        String hql = "from Treatment t where t.name = ?";
        Query query = session.createQuery(hql).setString(0, name);
        results = query.list();
    	  
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
		
		
	}

	@Override
	public List<Treatment> getAll() {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
        String hql = "from Treatment t ORDER BY t.name DESC";
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
