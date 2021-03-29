package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
 

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
	public class User implements Serializable {
		private static final long serialVersionUID = -5369734855993305723L;
	@Id
	private String username;
	private int mobile;
	private String login;
	private String pwd;
	 
 
	public User() {
		super();
	}
	public User(String username, int mobile, String login, String pwd) {
		super();
		this.username = username;
		this.mobile = mobile;
		this.login = login;
		this.pwd = pwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
		
	}
