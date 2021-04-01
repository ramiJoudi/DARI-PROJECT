package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.OneToMany;

 

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
	public class User implements Serializable {
		public User(String username, int mobile, String login, String pwd,
			Set<VORTEX.DARIPROJECT.ENTITY.WishList> wishList) {
		super();
		this.username = username;
		this.mobile = mobile;
		this.login = login;
		this.pwd = pwd;
		WishList = wishList;
	}
		private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private int mobile;
	private String login;
	private String pwd;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<WishList> WishList;
	 
 
	public User() {
		super();
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
	public Set<WishList> getWishList() {
		return WishList;
	}
	public void setWishList(Set<WishList> wishList) {
		WishList = wishList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
		
	}
