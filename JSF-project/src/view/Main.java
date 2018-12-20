package view;
import dal.*;
import java.util.List;
import dto.*;
import enums.*;
public class Main {
	
	public static void main(String[] args) {
		
		DAOFactory factory = new DAOFactory();
		//List<Course> allCourses = null;
		try
		{		
			// add course test
		
		Division division = new Division();
		/*
		division.setDepartment(Department.Electrical);
		division.setGrade(Grade.FirstYear);
		division.setName("Communication");
		*/
		division.setId(3);
		
		/*
		if(factory.createDivisionDAO().insert(division))
			System.out.println("division added");;
		*/
		/*
		Course course = new Course();
		course.setName("Civil");
		course.setCode("CI100");
		course.setDepartment(Department.Electrical);
		course.setGrade(Grade.FirstYear);
		course.setWeeklyLectureHours(4);
		course.setWeeklySectionHours(3);
		course.setDivision(division);
		*/
		
		Instructor instructor = new Instructor();
		instructor.setFullName("Ahmed Fayez");
		instructor.setEmail("example@fayoum.edu.eg");
		instructor.setPassword("1234");
		instructor.setAcademicDegree(AcademicDegree.AssistantLecturer);
		instructor.setDepartment(Department.Electrical);
		if(factory.createInstructorDAO().insert(instructor))
			System.out.println("Instructor added");
		
		
		/*
		if(factory.createCourseDAO().insert(course)) {
			System.out.println("Course added");
		}
		*/
		//getting all courses
		/*
		allCourses = factory.createCourseDAO().getAllCourses();
		
		 for (int i=0;i<=allCourses.size();i++) {
			 System.out.println(allCourses.get(i).getName());
			 System.out.println(allCourses.get(i).getCode());
			 System.out.println(allCourses.get(i).getGrade());
			 System.out.println(allCourses.get(i).getWeeklyLectureHours());
			 System.out.println(allCourses.get(i).getWeeklySectionHours());
		 }
		 */
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
}
}
