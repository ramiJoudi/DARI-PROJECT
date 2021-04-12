package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

 
@Entity
 public class customer extends User implements Serializable{
	private static final long serialVersionUID = -5369734855993305723L;
	
 
	
	final private int trial =4;
	
	



	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}






	public customer(int id, String username, int mobile, String pwd, String firstname, String lasttname, String email,
			boolean isEnabled) {
		super(id, username, mobile, pwd, firstname, lasttname, email, isEnabled);
		// TODO Auto-generated constructor stub
	}






	@OneToMany(mappedBy = "Client")
	private Set<Claim> claimsC;
	
	/*@OneToMany(mappedBy = "customer")
	private Set<Visit> visitsC;*/
 
	/*@OneToMany(cascade = CascadeType.ALL)
	private Set<Contract> Contracts;
	*/
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Chat> ChatsC;
	
	@OneToOne
	private subscription sub;
	
	@OneToMany
	private Set<Loan> loan_List;
	
	@ManyToOne
	private Ads ads;





 
	public int getTrial() {
		return trial;
	}
 
 
}
