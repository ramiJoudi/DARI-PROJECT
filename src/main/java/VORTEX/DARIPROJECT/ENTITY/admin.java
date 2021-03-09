package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 
@Entity
 
public class admin extends User implements Serializable{
	private static final long serialVersionUID = -5369734855993305723L;
 
	private int id; 
 
	
	public admin() {
		super();
	}

	
	 
	public admin(String username, int mobile, String login, String pwd, int id) {
		super(username, mobile, login, pwd);
		this.id = id;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	 

}
