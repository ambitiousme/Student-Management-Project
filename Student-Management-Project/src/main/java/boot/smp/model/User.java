package boot.smp.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_registration")
public class User {

	@Id 
	@Column(name = "user_id")
	@NotBlank(message = "User id cannot be blank") @Size(min = 6 , max = 15 , message = "User id must be between  6 and 12 characters.")
	@Pattern(regexp = "^[a-zA-Z0-9]{6,12}$", message = "username must be of 6 to 12 length with no special characters")
	private String userId;
	
	
	@Column(length=100) 
	@NotBlank(message = "User name cannot be blank") @Size(min = 1 , max = 50 , message = "User name must be between  1 and 50 characters.")
	private String userName ; 
	
	@NotBlank(message = "Password cannot be blank") @Size(min = 6 , max = 50 , message = "Password name must be of 6 length.")
	@Column(length = 250)
	private String password;

	@NotBlank(message = "Role cannot be blank")
	@Column(name = "userRole", length = 20)
	private String role;

	@NotBlank(message = "Email cannot be blank") @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@Column(length = 250,  unique = true)
	private String mail;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "regDate" )
	private Date registrationDate;
	  
    @PrePersist
    protected void onCreate() {
        registrationDate = new Date();
    }
    
	@OneToOne(mappedBy = "user")
	private Student student ;
	@OneToOne(mappedBy = "user")
	private Admin admin ;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User( String userName, String password, String role, String mail) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.mail = mail;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}



	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", mail=" + mail + ", registrationDate=" + registrationDate + "]";
	}

}
