package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.sun.istack.NotNull;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
	public class User implements Serializable {

		private static final long serialVersionUID = -5369734855993305723L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String firstname;
	private String lasttname;
	private int mobile;
	private String email; 
	private  boolean enabled;
	private String role;
	private String pwd;

	private int Asingaler_cmpt;
	private int Bsingaler_cmpt;
	public int getAsingaler_cmpt() {
		return Asingaler_cmpt;
	}
	public void setAsingaler_cmpt(int asingaler_cmpt) {
		Asingaler_cmpt = asingaler_cmpt;
	}
	public int getBsingaler_cmpt() {
		return Bsingaler_cmpt;
	}
	public void setBsingaler_cmpt(int bsingaler_cmpt) {
		Bsingaler_cmpt = bsingaler_cmpt;
	}
	public int getNsingaler_cmpt() {
		return Nsingaler_cmpt;
	}
	public void setNsingaler_cmpt(int nsingaler_cmpt) {
		Nsingaler_cmpt = nsingaler_cmpt;
	}
	private int Nsingaler_cmpt;
	private String resetPwdCode;
	

	 
 

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public User() {
		super();
	}
	public User(int id,String username, int mobile, String pwd,String firstname,String lasttname,String email,boolean enabled) {
		super();
		this.username = username;
		this.firstname=firstname;
		this.lasttname=lasttname;
		this.email=email;
		this.enabled=enabled;
		this.mobile = mobile;
		this.pwd = pwd;
		this.id=id;
	}
 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLasttname() {
		return lasttname;
	}
	public void setLasttname(String lasttname) {
		this.lasttname = lasttname;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
 
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
 
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getResetPwdCode() {
		return resetPwdCode;
	}
	public void setResetPwdCode(String resetPwdCode) {
		this.resetPwdCode = resetPwdCode;
	}

	 

	 
	}
