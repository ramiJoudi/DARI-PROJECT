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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 
@Entity
public class admin extends User implements Serializable{
	private static final long serialVersionUID = -5369734855993305723L;

	public admin() {
		super();
	 // TODO Auto-generated constructor stub
	}

	public admin(int id, String username, int mobile, String pwd, String firstname, String lasttname, String email,
			boolean enabled) {
		super(id, username, mobile, pwd, firstname, lasttname, email, enabled);
		// TODO Auto-generated constructor stub
	}

	 
 
 
 
	 

}
