package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
@Table(name="real_estate")

public class real_estate implements Serializable {
	
 

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="Status")
	private long status; 
	@Column(name="Location")
	private String location;
	@Column(name="Purchasing_price")
	private float purchasing_price;
	@Column(name="Buy")//true for buy 
	private boolean buy;
	@Column(name="Rent")//true for rent 
	private boolean rent;
	

 
	

	public real_estate(String location, float purchasing_price, boolean buy, boolean rent, WishList wishlist) {
		super();
		this.location = location;
		this.purchasing_price = purchasing_price;
		this.buy = buy;
		this.rent = rent;
		this.wishlist = wishlist;
		//this.ads = ads;
		//this.owner = owner;
	}



	public real_estate(long status, String location, float purchasing_price, boolean buy, boolean rent,
			WishList wishlist) {
		super();
		this.status = status;
		this.location = location;
		this.purchasing_price = purchasing_price;
		this.buy = buy;
		this.rent = rent;
		this.wishlist = wishlist;
		//this.ads = ads;
		//this.owner = owner;
	}



	public WishList getWishlist() {
		return wishlist;
	}



	public void setWishlist(WishList wishlist) {
		this.wishlist = wishlist;
	}


	
	
   @JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,optional = true)
@JoinColumn(name = "wishlist_id",nullable = true)
	private WishList wishlist;

	//@OneToMany(mappedBy = "real_estate")
	//private List<Claim> Claims;
	//@OneToMany(mappedBy = "real_estateV")
	//private Set<Visit> visits; 
	
	/*@OneToOne
	private Ads ads;*/

	/*@ManyToOne
	private owner owner;*/
	
	public real_estate() {
		super();
	}



	

	public long getStatus() {
		return status;
	}



	public void setStatus(long status) {
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

              
	



	/*public List<Claim> getClaims() {
		return Claims;
	}



	public void setClaims(List<Claim> claims) {
		Claims = claims;
	}*/


/*
	public Set<Visit> getVisits() {
		return visits;
	}



	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

*/

	public boolean isRent() {
		return rent;
	}



	public void setRent(boolean rent) {
		this.rent = rent;
	}



	



	public boolean isBuy() {
		return buy;
	}





	public void setBuy(boolean buy) {
		this.buy = buy;
	}



	/*public Ads getAds() {
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
	}*/
}
