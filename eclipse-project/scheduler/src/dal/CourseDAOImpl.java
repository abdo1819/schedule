package dal;

import java.util.List;

import dto.Course;
import dto.Division;
import enums.Department;
import utils.DBUtils;
import utils.IDGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
/**implemented by abdallah saied 4-12-2018 2:00 am...
 * last updated on 8/12/2018 by Ahmed Fayez (Added enums instead of look-up tables)
 * 
 * **/

public class CourseDAOImpl implements CourseDAO {
    /** getAllCourses() method returns a list which contains all the courses data..*/
    DAOFactory factory = new DAOFactory();
    @Override
    public List<Course> getAllCourses() {
    
        List<Course> result = null;
        Course course = null;
        try {
            String query = "SELECT * FROM COURSES ";
            Connection conn = DBUtils.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (result == null)
                    result = new ArrayList<Course>();
                course = new Course();

           
                course.setID(rs.getInt(1));
                course.setDepartment(Department.valueOf(rs.getString(2)));
                course.setDivision(factory.createDivisionDAO().getDivision(rs.getInt(3)));
                course.setName(rs.getString(4));
                course.setCode(rs.getString(5));
                course.setWeeklyLectureHours(rs.getInt(6));
                course.setWeeklySectionHours(rs.getInt(7));
                result.add(course);

            }

            conn.close();
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    /** getAllCourses(Department department) a method takes object of the class department and returns a list which contains all the courses data 
*/
	public List<Course> getCourses(Department department) {
		List<Course> result = null;
		Course course=null;
		try {
            String query = "SELECT * FROM COURSES WHERE DEPARTMENT=?";
            Connection conn = DBUtils.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,department.toString() ); //enum
            ResultSet rs = pst.executeQuery(query);

            while (rs.next()) {
                if (result == null)
                    result = new ArrayList<Course>();
                course = new Course();

                course.setID(rs.getInt(1));
                course.setDepartment(Department.valueOf(rs.getString(2)));
                course.setDivision(factory.createDivisionDAO().getDivision(rs.getInt(3)));
                course.setName(rs.getString(4));
                course.setCode(rs.getString(5));
                course.setWeeklyLectureHours(rs.getInt(6));
                course.setWeeklySectionHours(rs.getInt(7));
                result.add(course);
            }

            conn.close();
            pst.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    /**getAllCourses(Division division) a method takes object of the class division and returns a list which contains all the courses data
*/
    public List<Course> getCourses(Division division) {
        List<Course> result = null;
        Course course = null;
        try {
            String query = "SELECT * FROM COURSES WHERE DIVISION_ID=?";
            Connection conn = DBUtils.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, Integer.toString(division.getId()));
            ResultSet rs = pst.executeQuery(query);

            while (rs.next()) {
                if (result == null)
                    result = new ArrayList<Course>();
                course = new Course();

                course.setID(rs.getInt(1));
                course.setDepartment(Department.valueOf(rs.getString(2)));
                course.setDivision(factory.createDivisionDAO().getDivision(rs.getInt(3)));
                course.setName(rs.getString(4));
                course.setCode(rs.getString(5));
                course.setWeeklyLectureHours(rs.getInt(6));
                course.setWeeklySectionHours(rs.getInt(7));
                result.add(course);
            }

            conn.close();
            pst.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    @Override
    /** getCourse(Integer id) method takes the id of type Integer and returns the course with that id..*/
    public  Course getCourse(Integer iD){
        try {
        	
        String query = "SELECT * FROM COURSES WHERE COURSE_ID=? ";
        Connection conn = DBUtils.getConnection();
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, iD);
        ResultSet rs = pst.executeQuery();
        
        rs.next();
        Course course = new Course();
        course.setID(iD);
        course.setDepartment(Department.valueOf(rs.getString("department")));
        course.setDivision(factory.createDivisionDAO().getDivision(rs.getInt("division_id")));
        course.setName(rs.getString("name"));
        course.setCode(rs.getString("code"));
        course.setWeeklyLectureHours(rs.getInt("lecture_hours"));
        course.setWeeklySectionHours(rs.getInt("section_hours"));


        conn.close();
        pst.close();
        rs.close();
        return course;

    } catch (SQLException e) {
        e.printStackTrace();
    }
        
        catch(Exception e) {
        	e.printStackTrace();
        }
    return null;
    }
    @Override
    /** getCourse method takes the code and returns the course with that code..*/
    public Course getCourse(String code) {
    try {
        String query = "SELECT * FROM COURSES WHERE CODE=? ";
        Connection conn = DBUtils.getConnection();
        PreparedStatement pst = conn.prepareStatement(query);

        pst.setString(1, code);
        ResultSet rs = pst.executeQuery(query);

        Course course = new Course();
        course.setID(rs.getInt(1));
        course.setDepartment(Department.valueOf(rs.getString(2)));
        course.setDivision(factory.createDivisionDAO().getDivision(rs.getInt(3)));
        course.setName(rs.getString(4));
        course.setCode(code);
        course.setWeeklyLectureHours(rs.getInt(6));
        course.setWeeklySectionHours(rs.getInt(7));


        conn.close();
        pst.close();
        rs.close();
        return course;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
    }

    @Override
        /**insert(Course course) it's a method takes object of course  then insert it into the database and returns true if inserted false if not inserted
	*/
        public boolean insert(Course course) {
         Integer courseId =   IDGenerator.createPrimaryKey("courses");
	    try {
	    String query = "INSERT INTO COURSES(NAME,CODE,LECTURE_HOURS,SECTION_HOURS,DIVISION_ID,DEPARTMENT, TERM,course_id) "
	    		+ " VALUES(?,?,?,?,?,?,?,?)";
	    
		Connection conn = DBUtils.getConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1,course.getName());
		pst.setString(2,course.getCode());
		pst.setString(3,Integer.toString(course.getWeeklyLectureHours()));
        pst.setString(4,Integer.toString(course.getWeeklySectionHours()));
        pst.setString(5,Integer.toString(course.getDivision().getId()))  ;    
        pst.setString(6,course.getDepartment().toString());   
        pst.setString(7, "First Term");
        pst.setInt(8, courseId );
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

	@Override
        /**exists(course course) a method takes object of Course class then it checks if the code of this object course is already in database if yes it returns true if not it returns false
	*/
    public boolean exists(Course course) {
        try {
            String query = "SELECT * FROM COURSES WHERE code = '"+course.getCode()+"'";
            Connection conn = DBUtils.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                if (rs.getString(5).equalsIgnoreCase(course.getCode()))
                    conn.close();
                stmt.close();
                rs.close();
                return true;
            }

            conn.close();
            stmt.close();
            rs.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    // update(Course course) a method takes object of Course class then it UPDATES all the values and if updated returns true if not returns false

    public boolean update(Course course) {
        try {
            String query =
                "UPDATE COURSES SET NAME=?,CODE=?,LECTURE_HOURS=?,SECTION_HOUR =?,DIVISION_ID=?,DEPARTMENT_ID=? " +
                "WHERE COURSE_ID = ?";
            Connection conn = DBUtils.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, course.getName());
            pst.setString(2, course.getCode());
            pst.setString(3, Integer.toString(course.getWeeklyLectureHours()));
            pst.setString(4, Integer.toString(course.getWeeklySectionHours()));
            pst.setString(5, Integer.toString(course.getDivision().getId()));
            pst.setString(6, course.getDepartment().toString());
            pst.setString(7, Integer.toString(course.getID()));

            pst.executeQuery();
            conn.close();
            pst.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }

    @Override
    // delete(Course course) a method takes object of Course class then it DELETS IT FROM THE DATABASE if deleted returs true if not returns false
    public boolean delete(Course course) {
        try {
            String query = "DELETE FROM COURSES WHERE CODE=?";
            Connection conn = DBUtils.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, course.getCode());

            pst.executeQuery();
            conn.close();
            pst.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
