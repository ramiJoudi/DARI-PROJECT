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

	public customer(String username, int mobile, String login, String pwd,
			Set<VORTEX.DARIPROJECT.ENTITY.WishList> wishList, int customer_number, int trial, Set<Claim> claimsC,
			Set<Visit> visitsC, Set<Contract> contracts, Set<Deposit_of_guarantees> deposit_of_guarantes,
			Set<Chat> chatsC, subscription sub, Set<Loan> loan_List, Ads ads) {
		super(username, mobile, login, pwd, wishList);
		this.customer_number = customer_number;
		this.trial = trial;
		this.claimsC = claimsC;
		this.visitsC = visitsC;
		Contracts = contracts;
		Deposit_of_guarantes = deposit_of_guarantes;
		ChatsC = chatsC;
		this.sub = sub;
		this.loan_List = loan_List;
		this.ads = ads;
	}



	private static final long serialVersionUID = 1L;
	
	private int customer_number; 
	
	private int trial;
	
	
	 
 
	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	@OneToMany(mappedBy = "Client")
	private Set<Claim> claimsC;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customerV")
	private Set<Visit> visitsC;
 
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Contract> Contracts;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Deposit_of_guarantees> Deposit_of_guarantes;
	
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

	public Set<Deposit_of_guarantees> getDeposit_of_guarantes() {
		return Deposit_of_guarantes;
	}

	public void setDeposit_of_guarantes(Set<Deposit_of_guarantees> deposit_of_guarantes) {
		Deposit_of_guarantes = deposit_of_guarantes;
	}

	public Set<Claim> getClaimsC() {
		return claimsC;
	}

	public void setClaimsC(Set<Claim> claimsC) {
		this.claimsC = claimsC;
	}

	public Set<Visit> getVisitsC() {
		return visitsC;
	}

	public void setVisitsC(Set<Visit> visitsC) {
		this.visitsC = visitsC;
	}

	public Set<Contract> getContracts() {
		return Contracts;
	}

	public void setContracts(Set<Contract> contracts) {
		Contracts = contracts;
	}

	public Set<Chat> getChatsC() {
		return ChatsC;
	}

	public void setChatsC(Set<Chat> chatsC) {
		ChatsC = chatsC;
	}

	public subscription getSub() {
		return sub;
	}

	public void setSub(subscription sub) {
		this.sub = sub;
	}

	public Set<Loan> getLoan_List() {
		return loan_List;
	}

	public void setLoan_List(Set<Loan> loan_List) {
		this.loan_List = loan_List;
	}

	public Ads getAds() {
		return ads;
	}

	public void setAds(Ads ads) {
		this.ads = ads;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	 
}
