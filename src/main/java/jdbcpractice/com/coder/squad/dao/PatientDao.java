package jdbcpractice.com.coder.squad.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jdbcpractice.com.coder.squad.model.Patient;
import jdbcpractice.com.coder.squad.util.DBUtil;
import jdbcpractice.com.coder.squad.util.HibernateSessionFactory;

public class PatientDao {

	int id = 0;
	String name = "";
	String email = "";

	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction beginTransaction = null;
	Patient pt = null;

	public PatientDao() throws ClassNotFoundException, SQLException {
		pt = new Patient();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		// session = sessionFactory.openSession();
		// beginTransaction = session.beginTransaction();
	}

// Get All Patient Records Using Hibernate Query 
	public List<Patient> getAllPatient() throws SQLException {
		session = sessionFactory.openSession();
		Query<Patient> createQuery = session.createQuery("from jdbcpractice.com.coder.squad.model.Patient");
		List<Patient> list = createQuery.list();
		System.out.println("display All Records");

		return list;
	}

// Get Patient Details Based On Id Using Hibernate Get Method /Load also Can Use
	public Patient getPatientById(int id) throws SQLException {
		// while Insert/Update/Delete Use Transaction not for Select Queries
		session = sessionFactory.openSession();

		this.id = id;// important pass id in positional parameter
		Patient pt = session.get(Patient.class, this.id);

		return pt;
	}

// Delete Patient Records Based On Id Using Hibernate Reference method then delete method
	public void deletePatientById(int id) throws SQLException {
		session = sessionFactory.openSession();
		beginTransaction = session.beginTransaction();
		// beginTransaction.begin();
		this.id = id;
		// Patient patient = session.get(Patient.class,this.id);
		Patient reference = session.getReference(Patient.class, this.id);
		session.delete(reference);
		beginTransaction.commit();
		System.out.println("deleted");

	}

// Save Patient Records Using Hibernate Save method
	public int save(Patient p2) throws SQLException {
		int count = 0;
		session = sessionFactory.openSession();
		beginTransaction = session.beginTransaction();
		// beginTransaction.begin();
		pt = new Patient(p2.getpName(), p2.getpContact(), p2.getEmail(), p2.getpDate(), p2.isEnabled());

		Serializable save = session.save(pt);
		beginTransaction.commit();
		if (save != null) {
			count = 1;
			// return executeUpdate;
		}
		// beginTransaction.commit();
		return count;

		// TODO Auto-generated method stub

	}

	// if Name found duplicate then update flag=0
	public int isNameDuplicate(String name) throws SQLException {
		session = sessionFactory.openSession();
		// beginTransaction = session.beginTransaction();
		this.name = name;

		Query createQuery = session
				.createQuery("select p.pName from Patient p group by p.pName " + "having count(*)>1 ");

		List resultList = createQuery.getResultList();

		Object nam = resultList.get(0);
		beginTransaction = session.beginTransaction();
		Query createQuery2 = session.createQuery("update Patient p set p.enabled=false where p.pName=:name ");
		createQuery2.setParameter("name", nam);
		int executeUpdate = createQuery2.executeUpdate();
		beginTransaction.commit();
		if (executeUpdate > 0) {
			return executeUpdate;
		} else {
			return 0;
		}

	}

// update email of Old Id 
	public int updateEmailById(int id2, String email2) throws SQLException {
		session = sessionFactory.openSession();
		beginTransaction = session.beginTransaction();
		id = id2;
		email = email2;
		Query createQuery = session.createQuery("update Patient p set p.email=:email  where pId=:id ");
		createQuery.setParameter("email", email);
		createQuery.setParameter("id", id);
		int executeUpdate = createQuery.executeUpdate();
		beginTransaction.commit();
		if (executeUpdate > 0) {

			return executeUpdate;
		} else {
			return 0;
		}

		// TODO Auto-generated method stub

	}

	// TODO Auto-generated method stub

}
