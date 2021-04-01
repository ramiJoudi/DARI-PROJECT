package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
@Table( name= "D_real_estate")

public class real_estate implements Serializable {
	


	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="status")
	private int status; 
	@Column(name="location")
	private String location;
	@Column(name="purchasing_price")
	private float purchasing_price;
	@Column(name="buy_rent")//true for buy false for rent
	private boolean buy_rent;
	
	public real_estate(int status, String location, float purchasing_price, boolean buy_rent, List<Claim> claims,
			Set<Visit> visits, Set<Deposit_of_guarantees> dG, Ads ads, VORTEX.DARIPROJECT.ENTITY.owner owner) {
		super();
		this.status = status;
		this.location = location;
		this.purchasing_price = purchasing_price;
		this.buy_rent = buy_rent;
		Claims = claims;
		this.visits = visits;
		//DG = dG;
		this.ads = ads;
		this.owner = owner;
	}
 
	@OneToMany(mappedBy = "real_estate")
	private List<Claim> Claims;
	@OneToMany(mappedBy = "real_estateV")
	private Set<Visit> visits; 
	/*@OneToMany(mappedBy = "real_estate")
	private Set<Deposit_of_guarantees> DG;
	*/
	@OneToOne
	private Ads ads;

	@ManyToOne
	private owner owner;
	
	public real_estate() {
		super();
	}



	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getPurchasing_price() {
		return purchasing_price;
	}

	public void setPurchasing_price(float purchasing_price) {
		this.purchasing_price = purchasing_price;
	}

	public boolean isBuy_rent() {
		return buy_rent;
	}

	public void setBuy_rent(boolean buy_rent) {
		this.buy_rent = buy_rent;
	}                
	//commit test

	/*public Set<Deposit_of_guarantees> getDG() {
		return DG;
	}

	public void setDG(Set<Deposit_of_guarantees> dG) {
		DG = dG;
	}
*/


	public List<Claim> getClaims() {
		return Claims;
	}



	public void setClaims(List<Claim> claims) {
		Claims = claims;
	}



	public Set<Visit> getVisits() {
		return visits;
	}



	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}



	public Ads getAds() {
		return ads;
	}



	public void setAds(Ads ads) {
		this.ads = ads;
	}



	public owner getOwner() {
		return owner;
	}



	public void setOwner(owner owner) {
		this.owner = owner;
	}
}
