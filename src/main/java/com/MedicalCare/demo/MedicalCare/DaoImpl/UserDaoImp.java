package com.MedicalCare.demo.MedicalCare.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MedicalCare.demo.MedicalCare.Dao.UserDao;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;
import com.MedicalCare.demo.MedicalCare.Entities.User;

@Transactional
@Component
public class UserDaoImp implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public long addUser(User user) {
		Session session = sessionFactory.openSession();
		Long id = (long) 0;
        try {
            id=(Long) session.save(user);
            
        } catch (HibernateException e) {
           
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.openSession();
        try {
            session.update(user);
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

	@Override
	public User getUser(String userName, String password) {
		Session session = sessionFactory.openSession();
        User user = null;

        try {

            Query query = session.createQuery("from User u where u.username = ? and u.password = ?")
                    .setString(0, userName)
                    .setString(1, password);
            List<User> users = query.list();
            if(users.size()>0) {
            	user = users.get(0);
            }
            

        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
	}

	@Override
	public User getUserById(long id) {
		Session session = sessionFactory.openSession();
        User user=null;
       
       try{
        user=(User)session.get(User.class, id);

       }catch (Exception e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        if (user!=null) 
          return user;
        return null;
	}

	@Override
	public User getUserByUsername(String userName) {
		Session session = sessionFactory.openSession();
        User user = null;

        try {

            Query query = session.createQuery("from User u where u.username = ? ")
                    .setString(0, userName);
                    
            List<User> users = query.list();
            if(users.size()>0) {
            	user = users.get(0);
            }
            

        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
	}

	
}
