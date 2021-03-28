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
	public class owner extends User implements Serializable {
		private static final long serialVersionUID = -5369734855993305723L;
	 
		 
 
	 
		
		@OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
		private Set<real_estate> real_estates;





		public owner() {
			super();
			// TODO Auto-generated constructor stub
		}





		public owner(int id, String username, int mobile, String pwd, String firstname, String lasttname, String email,
				boolean isEnabled) {
			super(id, username, mobile, pwd, firstname, lasttname, email, isEnabled);
			// TODO Auto-generated constructor stub
		}





		 




	 
 

 

 
	  

}
