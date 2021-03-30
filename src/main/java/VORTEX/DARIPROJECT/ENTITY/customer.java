package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

 
@Entity
 public class customer extends User implements Serializable{
	private static final long serialVersionUID = -5369734855993305723L;
	
	private int customer_number; 
	
	private int trial;
	
	
	 
 
	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public customer(String username, int mobile, String login, String pwd,int customer_number,int trial) {
		super(username, mobile, login, pwd);
		this.customer_number=customer_number;
		this.trial=trial;
	}

	@OneToMany(mappedBy = "Client")
	private Set<Claim> claimsC;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customerV")
	private Set<Visit> visitsC;
 
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Contract> Contracts;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Chat> ChatsC;
	
	@OneToOne
	private subscription sub;
	
	@OneToMany
	private Set<Loan> loan_List;
	
	@ManyToOne
	private Ads ads;
	
	public int getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(int customer_number) {
		this.customer_number = customer_number;
	}

	 
 

	public int getTrial() {
		return trial;
	}

	public void setTrial(int trial) {
		this.trial = trial;
	}

	 
}
