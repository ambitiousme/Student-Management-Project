package boot.smp.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Student {

	@Id
	@Column(name = "rollnumber")
	private int studentRollNumber;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user ;

	@Column(name = "Name", length = 50, nullable = false)
	private String studentName;
	@Column(name = "Contact", length = 15, nullable = false, unique = true)
	private String contactNumber;
	@Column(length = 250, nullable = false)
	private String address;
	@Column(length = 250, nullable = false, unique = true)
	private String mailId;
	@Column(name = "BirthDate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(nullable = true)
	private int age;
	


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	

}
