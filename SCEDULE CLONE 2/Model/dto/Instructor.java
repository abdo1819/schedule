package dto;

import enums.AcademicDegree;
import enums.Department;
import enums.Role;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Instructor  {
    
    private ArrayList<Course> courses;
    
    private Integer id;
    private String fullName;
    private  String email;
    private String password;
    private String academicField;
    private Date dateOfEmployment;
    private AcademicDegree academicDegree; // db dependent
    private Department department; // academic degree?
    private  List<String> availableDays[];
    private Role role;




    public String getAcademicField() {
		return academicField;
	}


    public void setAcademicField(String academicField) {
		this.academicField = academicField;
	}






	public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

  

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Department getDepartment() {
        return department;
    }






	public List<String>[] getAvailableDays() {
		return availableDays;
	}






	public void setAvailableDays(List<String>[] availableDays) {
		this.availableDays = availableDays;
	}






	public void setDepartment(Department department) {
		this.department = department;
	}


    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}