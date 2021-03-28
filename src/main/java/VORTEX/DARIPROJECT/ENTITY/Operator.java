package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
 public class Operator extends User implements Serializable {
	private static final long serialVersionUID = -5369734855993305723L;
 
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Chat> chats;


	public Operator() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Operator(int id, String username, int mobile, String pwd, String firstname, String lasttname, String email,
			boolean isEnabled) {
		super(id, username, mobile, pwd, firstname, lasttname, email, isEnabled);
		// TODO Auto-generated constructor stub
	}


 

 
 




 
}
