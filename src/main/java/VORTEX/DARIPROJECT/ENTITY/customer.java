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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table( name= "D_customer")

public class customer implements Serializable{
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name="Customer_Id")
	private int customer_number; 

	private String name;
	
	private int mobile;
	
	private int trial;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Claim> Claims;
	
	@OneToOne
	private subscription sub;
	
	@OneToOne
	private Loan loan;

	@OneToOne
	private Contract contract;

	@OneToMany
	private Set<Visit> Visits;
	
	public int getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(int customer_number) {
		this.customer_number = customer_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public int getTrial() {
		return trial;
	}

	public void setTrial(int trial) {
		this.trial = trial;
	}

	public customer() {
		super();
	}

	public customer(int customer_number, String name, int mobile, int trial) {
		super();
		this.customer_number = customer_number;
		this.name = name;
		this.mobile = mobile;
		this.trial = trial;
	}
}
