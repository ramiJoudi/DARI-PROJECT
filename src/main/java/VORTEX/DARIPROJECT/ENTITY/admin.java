package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table( name= "D_admin")
public class admin implements Serializable{

	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name="Id_Admin")
	private int id; 

	private String loginAdmin;

	private String pwAdmin;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Claim> Claims;
	
	public admin() {
		super();
	}

	public admin(int id, String loginAdmin, String pwAdmin) {
		super();
		this.id = id;
		this.loginAdmin = loginAdmin;
		this.pwAdmin = pwAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginAdmin() {
		return loginAdmin;
	}

	public void setLoginAdmin(String loginAdmin) {
		this.loginAdmin = loginAdmin;
	}

	public String getPwAdmin() {
		return pwAdmin;
	}

	public void setPwAdmin(String pwAdmin) {
		this.pwAdmin = pwAdmin;
	}
	

}
