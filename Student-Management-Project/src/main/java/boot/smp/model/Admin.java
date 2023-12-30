package boot.smp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Admin {

	@Id
	@Column(name = "id")
	private int adminId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user ;
	
	@Column(name = "name", length = 50, nullable = false)
	private String adminName;
	@Column(length = 50, nullable = false, unique = true)
	private String userName;
	@Column(length = 250, nullable = false)
	private String password;
	@Column(length = 250, nullable = false, unique = true)
	private String mailId;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminId, User user, String adminName, String userName, String password, String mailId) {
		super();
		this.adminId = adminId;
		this.user = user;
		this.adminName = adminName;
		this.userName = userName;
		this.password = password;
		this.mailId = mailId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
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

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", user=" + user + ", adminName=" + adminName + ", userName=" + userName
				+ ", password=" + password + ", mailId=" + mailId + "]";
	}
    
	
}
