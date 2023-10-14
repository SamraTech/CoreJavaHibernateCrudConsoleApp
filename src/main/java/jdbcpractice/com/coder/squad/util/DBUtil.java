package jdbcpractice.com.coder.squad.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private DBUtil() {

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class<?> forName = Class.forName("com.mysql.jdbc.Driver");
		System.out.println(forName.getCanonicalName());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pateintclinic", "root", "hamid");

		return con;

	}
	
}
