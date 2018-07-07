package com.MedicalCare.demo.MedicalCare.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MedicalCare.demo.MedicalCare.Dao.RoleDao;
import com.MedicalCare.demo.MedicalCare.Entities.security.Role;

@Transactional
@Component
public class RoleDaoImp implements RoleDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addRole(Role role) {
		Session session = sessionFactory.openSession();
		
        try {
        	System.out.println("------------------------------------777777777777777777777-----------------------");
              session.save(role);
             System.out.println("//////////////---------------***********************-------------//////////////////");
        } catch (Exception e) {
           System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
            e.printStackTrace();
        } finally {
            session.close();
        }
        
	}

	@Override
	public List<Role> getAll() {
		Session session = sessionFactory.openSession();
        List results = null;
       try{
      
        String hql = "from Role ";
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
