package utils;
import java.sql.*;
/**
 * 
 * @author Ahmed Fayez
 * Created on 30th, November 2018
 * Last updated on 8/12/2018
 */
public class DBUtils {
	/**
	 * A static method that returns a connection object 
	 * for further usage whenever a connection needs to be created
	 * @return Connection object
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try
		{
		// Class.forName("oracle.jdbc.Driver.OracleDriver");
		String url = "jdbc:oracle:thin:dbusername/oracle@localhost:1521:XE";
		conn = DriverManager.getConnection(url, "dbusername", "oracle");
		}
		catch (SQLException e) {
			System.out.println("SQL exception at DB connection");
			e.printStackTrace();
		}
		/*
		catch (ClassNotFoundException e) {
			System.out.println("Class not found exception");
			e.printStackTrace();
		}
		*/
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
