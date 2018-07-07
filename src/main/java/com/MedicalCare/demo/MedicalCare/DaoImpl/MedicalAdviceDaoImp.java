package com.MedicalCare.demo.MedicalCare.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MedicalCare.demo.MedicalCare.Dao.MedicalAdviceDao;
import com.MedicalCare.demo.MedicalCare.Entities.Disease;
import com.MedicalCare.demo.MedicalCare.Entities.MedicalAdvice;
import com.MedicalCare.demo.MedicalCare.Entities.diognes;

@Transactional
@Component
public class MedicalAdviceDaoImp implements MedicalAdviceDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long addMedicalAdvice(MedicalAdvice ma) {
		 Session session = sessionFactory.openSession();
		 long id =0;
	        try {
	           id= (long) session.save(ma);
	        } catch (HibernateException e) {
	            
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return id;
	}

	@Override
	public List<MedicalAdvice> getDiseasesAdvices(int diseasesID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
//        String hql = "from medicalAdvice ma where ma.diseas_id = ? ";
//        Query query = session.createQuery(hql).setInteger(0, diseasesID);
//        results = query.list();
    	   Disease disease = session.get(Disease.class, diseasesID);
    	   if(disease!=null) {
    	   results = disease.getMedicalAdviceList();
    	   }
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

	@Override
	public List<MedicalAdvice> getDiognesAdvices(long diognesID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{      
//        String hql = "from medicalAdvice ma where ma.diognes_id = ? ";
//        Query query = session.createQuery(hql).setLong(0, diognesID);
//        results = query.list();
    	   diognes d = session.get(diognes.class, diognesID);
    	   if(d!=null) {
    	   results = d.getMedicalAdvicesList();
    	   }
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

}
