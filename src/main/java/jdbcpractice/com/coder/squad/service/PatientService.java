package jdbcpractice.com.coder.squad.service;

import java.sql.SQLException;
import java.util.List;

import jdbcpractice.com.coder.squad.dao.PatientDao;
import jdbcpractice.com.coder.squad.model.Patient;

public class PatientService {
	PatientDao dao;
	Patient p = null;
	int flag = 0;

	public PatientService(PatientDao dao) {
		super();
		this.dao = dao;
		p = new Patient();
	}

	public List<Patient> getAllPatient() throws SQLException {

		return dao.getAllPatient();

	}

	public Patient getPatientById(int id) throws SQLException {
		
		return dao.getPatientById(id);

	}

	public void deletePatientById(int id) throws SQLException {
		
		dao.deletePatientById(id);
	
		// TODO Auto-generated method stub

	}

	public int save(Patient p2) throws SQLException {
		// TODO Auto-generated method stub
		flag=dao.save(p2);
		return flag;
		
	}

	public int isNameDuplicate(String name) throws SQLException {
		return dao.isNameDuplicate(name);
		
	}

	public int updateEmailByName(int id, String email) throws SQLException {
		
		
		return dao.updateEmailById(id,email);
		// TODO Auto-generated method stub
		
	}

}
