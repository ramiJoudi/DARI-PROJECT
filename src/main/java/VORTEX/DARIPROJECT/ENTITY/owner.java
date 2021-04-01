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
	 
		private int number_o; 
		private String name;
		private int phone_number;
		
		@OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
		private Set<real_estate> real_estates;

	 
		public owner(String username, int mobile, String login, String pwd, int number_o, String name,
				int phone_number) {
			//super(username, mobile, login, pwd);
			this.number_o = number_o;
			this.name = name;
			this.phone_number = phone_number;
		}
		

		/*public owner(String username, int mobile, String login, String pwd) {
			super(username, mobile, login, pwd);
		}*/


		public int getNumber_o() {
			return number_o;
		}

		public void setNumber_o(int number_o) {
			this.number_o = number_o;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(int phone_number) {
			this.phone_number = phone_number;
		}
		
		

}
