package com.MedicalCare.demo.MedicalCare.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MedicalCare.demo.MedicalCare.Dao.AnalysisDao;
import com.MedicalCare.demo.MedicalCare.Entities.Analysis;
import com.MedicalCare.demo.MedicalCare.Entities.Doctor;
import com.MedicalCare.demo.MedicalCare.Entities.Patient;

@Transactional
@Component
public class AnalysisDaoImp implements AnalysisDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addAnalysis(Analysis analysis) {

		Session session = sessionFactory.openSession();
		long id = 0;
		try {

			session.saveOrUpdate(analysis);
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public List<Analysis> getPatientAnalysises(long patientID) {
		Session session = sessionFactory.openSession();
		List results = null;
		try {

			// Query query = session.createQuery("from analysis where pat_id = ? ")
			// .setLong(0, patientID);
			Patient patient = (Patient) session.get(Patient.class, patientID);
			if (patient != null) {
				results = patient.getAnalysises();
			}
			// results = query.list();
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return results;
	}

	@Override
	public List<Analysis> getDiognesesByDoctorID(long doctorID) {
		Session session = sessionFactory.openSession();
		List results = null;
		try {

			// Query query = session.createQuery("from analysis where doc_id = ? ")
			// .setInteger(0, doctorID);
			// results = query.list();
			Doctor doctor = (Doctor) session.get(Doctor.class, doctorID);
			if(doctor!=null) {
			results = doctor.getAnalysises();
			}
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return results;
	}

	@Override
	public List<Analysis> getDoctorToPatientDiogneses(long doctorID, long patientID) {
		Session session = sessionFactory.openSession();
		List results = null;
		try {

			Query query = session.createQuery("from Analysis where doc_id = ? and pat_id = ? ").setLong(0, doctorID)
					.setLong(1, patientID);
			results = query.list();

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return results;
	}

	@Override
	public Analysis getAnalysis(Long id) {

		Session session = sessionFactory.openSession();
		Analysis analysis = null;
		try {
			analysis = session.get(Analysis.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return analysis;
	}

}
