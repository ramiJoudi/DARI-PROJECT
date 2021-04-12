package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Set;

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
@Table( name= "t_subscription")
public class subscription implements Serializable{
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int idSub; 
	
	private String offer;
	@Column
	private boolean sub;
	
	@Column
	private Long price ; 
	
	
	public Long getPrice() {
		return price;
	}

	public subscription(String offer, boolean sub, Long price) {
		super();
		this.offer = offer;
		this.sub = sub;
		this.price = price;
	}

	public subscription(int idSub, String offer, boolean sub, Long price) {
		super();
		this.idSub = idSub;
		this.offer = offer;
		this.sub = sub;
		this.price = price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	/*@OneToOne(mappedBy = "sub")
	private customer customer;
*/
	public subscription(int idSub, String offer) {
		super();
		this.idSub = idSub;
		this.offer = offer;
	}

	public subscription() {
		super();
	}

	public int getIdSub() {
		return idSub;
	}

	public void setIdSub(int idSub) {
		this.idSub = idSub;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}
	public boolean isSub() {
		return sub;
	}

	public void setSub(boolean sub) {
		this.sub = sub;
	}

	
}
