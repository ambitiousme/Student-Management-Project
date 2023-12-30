package boot.smp.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Enrollment {

	/*
	 * enrollment_id INT PRIMARY KEY AUTO_INCREMENT, student_id INT, course_id INT,
	 * enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY (student_id)
	 * REFERENCES student(student_id), FOREIGN KEY (course_id) REFERENCES
	 * course(course_id)
	 */ 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enrolId")
	private int enrollmentID;

	 @ManyToOne
	 @JoinColumn(name = "student_id")
	private Student student;
	 @ManyToOne
	    @JoinColumn(name = "course_id")
	private Course course;

	@Temporal(TemporalType.TIME) 
	private Date enrolDate;

	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollment(int enrollmentID, Student student, Course course, Date enrolDate) {
		super();
		this.enrollmentID = enrollmentID;
		this.student = student;
		this.course = course;
		this.enrolDate = enrolDate;
	}

	public int getEnrollmentID() {
		return enrollmentID;
	}

	public void setEnrollmentID(int enrollmentID) {
		this.enrollmentID = enrollmentID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getEnrolDate() {
		return enrolDate;
	}

	public void setEnrolDate(Date enrolDate) {
		this.enrolDate = enrolDate;
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentID=" + enrollmentID + ", student=" + student + ", course=" + course
				+ ", enrolDate=" + enrolDate + "]";
	}

}
