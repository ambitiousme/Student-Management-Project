package boot.smp.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "INT", name= "course_id")
	private int courseId;

	@Column(length = 50, nullable = false)
	private String course_code;
	@Column(length = 50, nullable = false)
	private String course_name;
	@Column(length = 250)
	private String description;
	
	 
	

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Course(int courseId, String course_code, String course_name, String description) {
		super();
		this.courseId = courseId;
		this.course_code = course_code;
		this.course_name = course_name;
		this.description = description;
	}




	public int getCourseId() {
		return courseId;
	}




	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}




	public String getCourse_code() {
		return course_code;
	}




	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}




	public String getCourse_name() {
		return course_name;
	}




	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", course_code=" + course_code + ", course_name=" + course_name
				+ ", description=" + description + "]";
	}
 
	
}
