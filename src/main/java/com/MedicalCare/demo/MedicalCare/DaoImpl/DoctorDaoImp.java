package com.MedicalCare.demo.MedicalCare.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MedicalCare.demo.MedicalCare.Dao.DoctorDao;
import com.MedicalCare.demo.MedicalCare.Entities.Address;
import com.MedicalCare.demo.MedicalCare.Entities.Doctor;
import com.MedicalCare.demo.MedicalCare.Entities.Hospital;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;

@Transactional
@Component
public class DoctorDaoImp implements DoctorDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long addDoctor(Doctor doctor) {
		Session session = sessionFactory.openSession();
		long id=0;
        try {
            id =(long) session.save(doctor);
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
	}

	@Override
	public void updateImage(long doctorId, byte[] newImage) {
		Session session = sessionFactory.openSession();
        Doctor doctor = null;
        try {
            Query qry = session.createQuery("update Doctor d set d.image=? where p.id=?");
            qry.setParameter(0, newImage);
            qry.setParameter(1, doctorId);
            int res = qry.executeUpdate();

        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		Session session = sessionFactory.openSession();
        try {
            
            session.update(doctor);
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }
	}

	@Override
	public List<Doctor> getDoctorsOfHospital(int hospitalId) {
		Session session = sessionFactory.openSession();
        List results = null;
        try {

//            Query query = session.createQuery("from Doctor d where d.hos_id = ?")
//                    .setInteger(0, hospitalId);
//            results = query.list();
        	Hospital hospital = session.get(Hospital.class, hospitalId);
        	if(hospital!=null) {
        	results = hospital.getDoctors();
        	}
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;
	}

	@Override
	public Doctor getDoctor(long doctorID) {
		Session session = sessionFactory.openSession();
        Doctor doctor = null;

        try {
            doctor = (Doctor) session.get(Doctor.class, doctorID);
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (doctor != null) {
            return doctor;
        }
        return null;
	}

	@Override
	public List<Doctor> getPatientDoctors(long patientID) {
		Session session = sessionFactory.openSession();
        List results = null;
       try{      
        Patient patient =(Patient) session.get(Patient.class, patientID);
        if(patient!=null) {
        results = patient.getDoctors();
        }
       }catch (HibernateException e) {
             
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
	}

	@Override
	public List<Doctor> getDoctorByName(String doctorName) {
		Session session = sessionFactory.openSession();
        List results = null;
        try {
            Query query = session.createQuery("from Doctor d where d.name = ?")
                    .setString(0, doctorName);
            results = query.list();
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;
	}

	@Override
	public List<Doctor> getDoctorsByClinicAddress(Address clinicAddress) {
		Session session = sessionFactory.openSession();
        List results = null;
        try {
        	
            Query query = session.createQuery("from Doctor d where d.clinicGoverment = ? and d.clinikCity = ? ")
                    .setString(0, clinicAddress.getGoverment())
                    .setString(1, clinicAddress.getCity());
            results = query.list();
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;
	}

	@Override
	public List<Doctor> getDoctorsByDerartment(String doctorDepartment) {
		Session session = sessionFactory.openSession();
        List results = null;
        try {

            Query query = session.createQuery("from Doctor d where doctor_department = ? ")
                    .setString(0, doctorDepartment);
                    
            results = query.list();
        } catch (HibernateException e) {
            
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;
	}

}
