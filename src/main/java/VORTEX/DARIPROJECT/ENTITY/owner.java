package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


	@SuppressWarnings("serial")
	@Entity
	@Table( name= "D_owner")
	public class owner implements Serializable {
		
		@Id
		@GeneratedValue (strategy= GenerationType.AUTO)
		private int number_o; 
		
		private String name;
		private int phone_number;
		
		@OneToMany
		private Set<real_estate> real_estates;

		public owner(int number_o, String name, int phone_number) {
			super();
			this.number_o = number_o;
			this.name = name;
			this.phone_number = phone_number;
		}

		public owner() {
			super();
		}

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
