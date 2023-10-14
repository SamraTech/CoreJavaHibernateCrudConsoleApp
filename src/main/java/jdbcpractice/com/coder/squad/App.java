package jdbcpractice.com.coder.squad;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jdbcpractice.com.coder.squad.dao.PatientDao;
import jdbcpractice.com.coder.squad.model.Patient;
import jdbcpractice.com.coder.squad.service.PatientService;
// Use Mysql 8 for Database and Mysql 5 for Driver class
// Better Use Maven tool easy for Dependency version 
public class App {

	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
		// Connection con = DBUtil.getConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Choice");
		PatientDao dao = new PatientDao();
		Patient pt = null;
		List<Patient> ptlist = new ArrayList<Patient>();
		PatientService ps = new PatientService(dao);

		int id = 0;
		String name = "";
		String cont = "";
		String email = "";
		// Date datee = null;
		boolean flag = false;
		// int count = 0;
		// select * from patirnt where name="Hamid";
		while (true) {
			System.out.println("enter your choice");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Display Patient Records");
				ptlist = ps.getAllPatient();
				System.out.println(ptlist);

				break;
			case 2:
				System.out.println("Get Patient record by Id");
				id = sc.nextInt();
				pt = ps.getPatientById(id);
				System.out.println(pt);
				break;

			// System.out.print(patientById);
			case 3:
				System.out.println("Delete record of Patient");
				System.out.println("enter id of Patient");
				id = sc.nextInt();
				ps.deletePatientById(id);

				System.out.println("deleted successfully");

				break;
			case 4:
				System.out.println("insert patient record");
				// id = sc.nextInt();
				System.out.println("enter Name");
				name = sc.next();
				System.out.println("enter Cont");
				cont = sc.next();
				System.out.println("enter Email");
				email = sc.next();
				System.out.println("enter Date");
				String date = sc.next();
				System.out.println("enter Flaf value");
				flag = sc.nextBoolean();
				// String date="2023-10-10";

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parse2 = format.parse(date);
				// java.sql.Date sqlDate = new java.sql.Date(parse2.getTime());

				java.sql.Date sqlDat = new java.sql.Date(parse2.getTime());
				Patient p = new Patient(name, cont, email, sqlDat, flag);
				int save = ps.save(p);
				if (save > 0) {
					System.out.println("inserted");
				}

				break;
			case 5:
				System.out.println("Update flag value 1 to 0 when column name is same");
				System.out.println("enter Name of Patient");
				name = sc.next();
				pt = new Patient(name);
				int nameDuplicate = ps.isNameDuplicate(pt.getpName());
				if (nameDuplicate > 0) {
					System.out.println("update with flag");
				}
				break;
			case 6:
				System.out.println("Update Email of Patient by Name");
				System.out.println("enter new email");
				email = sc.next();
				System.out.println("enter old Id");
				id = sc.nextInt();
				pt = new Patient(id, email);
				int updateEmailByName = ps.updateEmailByName(id, email);
				if (updateEmailByName > 0) {
					System.out.println("Done with UPdate");
				}
				break;

			default:
				System.out.println("All Condition failed");
				System.out.println("Please Enter Proper Info from 1 to 6");
				System.out.println();
				break;
			}

		}

		// ps.insertPatient();

	}
}