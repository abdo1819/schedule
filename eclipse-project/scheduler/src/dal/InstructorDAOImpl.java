package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Instructor;
import utils.DBUtils;
import utils.IDGenerator;
import utils.DateUtils;
import enums.*;

/**
 * @author Mahmoud Elsayed Mohamed
 * created on Dec 1, 2018
 * last edited on Dec 3, 2018
 * last updated on 8/12/2018 by Ahmed Fayez (Added enums instead of look-up tables)
 */
public class InstructorDAOImpl implements InstructorDAO {
	/**
	 * The following method "getInstructor)" gets some of instructor data 
	 * And takes one parameter (string email)
	 */
	@Override
	public Instructor getInstructor(String email) {
		Instructor instructor = new Instructor();
		// AcademicDegree academicDegree = new AcademicDegree();
		try {
			String query = "SELECT * FROM USERS WHERE EMAIL='"+email+" ' ";		
			Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			
			instructor.setEmail(rs.getString(2));
			instructor.setFullName(rs.getString(4));
			instructor.setDateOfEmployment(rs.getDate(5));
			instructor.setAcademicDegree(AcademicDegree.valueOf(rs.getString("ACADEMIC_DEGREE")));
			instructor.setDepartment(Department.valueOf(rs.getString("DEPARTMENT")));
			}
		
		conn.close();
		stmt.close();
		rs.close();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return instructor;
	}
	
	/**
	 * The following method "getAllInstructor)" gets all instructors 
	 * And takes no parameters
	 */
	@Override
	public List<Instructor> getAllInstructors() {
		List<Instructor> instructors = null;
		Instructor instructor = null;
		// AcademicDegree academicDegree = new AcademicDegree();

		new DAOFactory();
		try {
			String sql = "SELECT * FROM USERS";
			Connection connection = DBUtils.getConnection();
			PreparedStatement pstatement = connection.prepareStatement(sql);	
			ResultSet result = pstatement.executeQuery();
		while(result.next()) {
			if(instructors == null)
				instructors = new ArrayList<>();
			instructor = new Instructor();
			instructor.setEmail(result.getString("EMAIL"));
			instructor.setFullName(result.getString("FULL_NAME"));
			instructor.setDateOfEmployment(DateUtils.convert(result.getString("date_of_employment")));
			instructor.setAcademicDegree(AcademicDegree.valueOf(result.getString("ACADEMIC_DEGREE")));
			instructor.setDepartment(Department.valueOf(result.getString("DEPARTMENT")));
			instructors.add(instructor);
			}
		connection.close();
		pstatement.close();
		result.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return instructors;
	}

	/**
	 * The following method "getAllInstructor)" gets all instructors 
	 * And takes one parameter (Department object)
	 */
	@Override
	public List<Instructor> getInstructors(Department department) {
		List<Instructor> result = new ArrayList<Instructor>();
		Instructor instructor = new Instructor();
		// AcademicDegree academicDegree = new AcademicDegree();
		
		try {
			String query = "SELECT * FROM USERS WHERE DEPARTMENT_ID=?";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pstatement = conn.prepareStatement(query);	
			ResultSet rs = pstatement.executeQuery(query);
		while(rs.next()) {
			
			instructor.setEmail(rs.getString("EMAIL"));
			instructor.setFullName(rs.getString("FULL_NAME"));
			instructor.setDateOfEmployment(rs.getDate("DATE_OF_EMPLOYMENT"));
			instructor.setAcademicDegree(AcademicDegree.valueOf(rs.getString("ACADEMIC_DEGREE")));
			instructor.setDepartment(department);
			
			result.add(instructor);
			
			}
		
		conn.close();
		pstatement.close();
		rs.close();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * The following method "getAllInstructor)" gets all instructors 
	 * And takes one parameter (AcademicDegree object)
	 */

	@Override
	public List<Instructor> getInstructors(AcademicDegree academicDegree) {
		List<Instructor> result = new ArrayList<Instructor>();
		Instructor instructor = new Instructor();

		try {
			String query = "SELECT * FROM USERS WHERE Academic_Degree=?";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pstatement = conn.prepareStatement(query);	
			ResultSet rs = pstatement.executeQuery(query);
		while(rs.next()) {
			
			instructor.setEmail(rs.getString("EMAIL"));
			instructor.setFullName(rs.getString("FULL_NAME"));
			instructor.setDateOfEmployment(rs.getDate("DATE_OF_EMPLOYMENT"));
			instructor.setAcademicDegree(academicDegree);
			instructor.setDepartment(Department.valueOf(rs.getString("DEPARTMENT")));
			result.add(instructor);
			}
		
		conn.close();
		pstatement.close();
		rs.close();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 * The following method adds a new instructor to database
	 * it takes one parameter (instructor object)
	 */
	@Override
	public boolean insert(Instructor instructor) {
		Integer instructorId = IDGenerator.createPrimaryKey("users");
		try {
			String query = "INSERT INTO USERS(user_id,EMAIL,PASSWORD,FULL_NAME,DATE_OF_EMPLOYMENT,ACADEMIC_FIELD,ROLE,DEPARTMENT,ACADEMIC_DEGREE) VALUES(?,?,?,?,?,?,?,?,?)";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, instructorId);
			pst.setString(2, instructor.getEmail());
			pst.setString(3, instructor.getPassword());
			pst.setString(4,instructor.getFullName());
			pst.setString(5,DateUtils.convert(instructor.getDateOfEmployment()));
			pst.setString(6, instructor.getAcademicField());
			pst.setString(7, Role.Instructor.toString());
			pst.setString(8, instructor.getDepartment().toString());
			pst.setString(9, instructor.getAcademicDegree().toString());
			pst.executeQuery();
			conn.close();
			pst.close();
			
			return true;
			
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

	/**
	 * The following method "exist()" checks the existence of the instructor in DB
	 * it takes one parameter (Instructor object)
	 */
	@Override
	public boolean exists(Instructor instructor) {
		try {
			String query = "SELECT * FROM USERS  WHERE EMAIL='\"+email+\"'";
			Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
				while(rs.next())
				{
					if(rs.getString(2).equals(instructor.getEmail()))
						return true;	
				}
				
				conn.close();
				stmt.close();
				rs.close();
				
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			return false;
	}

	/**
	 * The following method "update()" updates the instructor data in DB
	 * it takes one parameter (Instructor object)
	 */
	@Override
	public boolean update(Instructor instructor) {
		try {
			String query = "UPDATE USERS SET EMAIL=?,PASSWORD=? ,FULL_NAME=? ,DATE_OF_EMPLOYMENT=? ,ACADEMIC_FIELD=?,ROLE_ID=?,DEPARTMENT_ID=? ,ACADEMIC_DEGREE_ID=?WHERE EMAIL='\"+email+\"'";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);

			pst.setString(2, instructor.getEmail());
			pst.setString(3, instructor.getPassword());
			pst.setString(4,instructor.getFullName());
			pst.setString(5,DateUtils.convert(instructor.getDateOfEmployment()));
			pst.setString(6, instructor.getAcademicField());
			pst.setString(7, instructor.getDepartment().toString());
			pst.setString(8, Role.Instructor.toString());
			pst.setString(9, instructor.getAcademicDegree().toString());
			pst.executeQuery();
			conn.close();
			pst.close();
			
			return true;
			
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
	}

	/**
	 * The following method "delete()" deletes the  instructor data form DB
	 * it takes one parameter (Instructor object)
	 */
	@Override
	public boolean delete(Instructor instructor) {
		try {
			String query = "DELETE FROM INSTRUCTOR WHERE EMAIL='"+instructor.getEmail()+"'";
			Connection conn = DBUtils.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
			
			pst.setString(4, instructor.getEmail());
			pst.executeQuery();
			conn.close();
			pst.close();
			
			return true;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
	}

	
	/**
	 * returns specific instructor from its primary key
	 */
	@Override
	public Instructor getInstructor(Integer id) {
		Instructor inst = null;
		String query = "select * from users where user_id = '"+id+"'";
		try(Connection con = DBUtils.getConnection();
			Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);)
		{
			rs.next();
			inst = new Instructor();
			inst.setFullName(rs.getString("full_name"));
			inst.setEmail(rs.getString("email"));
			inst.setPassword(rs.getString("password"));
			inst.setDateOfEmployment(DateUtils.convert(rs.getString("date_of_employment")));
			inst.setAcademicDegree(AcademicDegree.valueOf(rs.getString("academic_degree")));
			inst.setDepartment(Department.valueOf(rs.getString("department")));
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		catch(NullPointerException e)  {
			inst.setDateOfEmployment(DateUtils.convert(""));
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return inst;
	}

}
